package banking.api.user.controller

import banking.api.user.domain.UpdateUserProfileRequest
import banking.api.user.domain.UserProfileRequest
import banking.api.user.domain.UserProfileResponse
import banking.api.user.service.UserProfileService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserProfileController(val userProfileService:UserProfileService): UserProfileResource{

    override fun createUserProfile(request: UserProfileRequest): UserProfileResponse {
        return userProfileService.createUserProfile(request)
    }

    override fun getUserProfileById(id: String): UserProfileResponse {
        return userProfileService.getUserProfileById(id)
    }

    override fun getUserProfileByEmail(email: String): UserProfileResponse {
        return userProfileService.getUserProfileByEmail(email)
    }

    override fun getAllUserProfiles(): List<UserProfileResponse> {
        return userProfileService.getAllUserProfiles()
    }

    override fun updateUserProfile(id: String, updateRequest: UpdateUserProfileRequest): UserProfileResponse {
        return userProfileService.updateUserProfile(id,updateRequest)
    }
}