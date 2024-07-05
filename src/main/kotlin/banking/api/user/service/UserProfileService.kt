package banking.api.user.service

import banking.api.login.service.UserIdentityService
import banking.api.user.convertor.toUserProfileEntity
import banking.api.user.convertor.userResponse
import banking.api.user.domain.UpdateUserProfileRequest
import banking.api.user.domain.UserProfileRequest
import banking.api.user.domain.UserProfileResponse
import banking.api.user.persistence.entity.AddressEntity
import banking.api.user.persistence.entity.UserProfileEntity
import banking.api.user.persistence.repository.UserProfileRepository
import banking.util.toLocalDate
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository,
    private val userIdentityService: UserIdentityService
) {

    fun createUserProfile(request: UserProfileRequest): UserProfileResponse {
        return userProfileRepository
            .save(request.toUserProfileEntity())
            .also { userProfile -> userIdentityService.createUserIdentity(userProfile, request) }
            .userResponse()
    }

    fun getAllUserProfiles(): List<UserProfileResponse> {
        return userProfileRepository.findAll().map { it.userResponse() }
    }

    fun getUserProfileById(id: String): UserProfileResponse {
        return userProfileRepository.findById(id).get().userResponse()
    }

    fun getUserProfileByEmail(email: String): UserProfileResponse {
        return userProfileRepository.findByEmail(email).userResponse()
    }

    fun updateUserProfile(id: String, updateRequest: UpdateUserProfileRequest): UserProfileResponse {
        val userProfile: UserProfileEntity = userProfileRepository.findById(id).get()
        val updateEntity = userProfile.copy(
            type = updateRequest.userType,
            firstName = updateRequest.firstName,
            lastName = updateRequest.lastName,
            email = updateRequest.email,
            phone = updateRequest.phone,
            dateOfBirth = updateRequest.dateOfBirth.toLocalDate(),
            addresses = updateRequest.addresses.map { address ->
                AddressEntity(
                    type = address.type,
                    street = address.street,
                    city = address.city,
                    state = address.state,
                    zip = address.zip,
                    country = address.country,
                    userProfile = userProfile // Link back to the user profile
                )
            }.toMutableList()
        )

        return userProfileRepository.save(updateEntity).userResponse()
    }
}