package banking.api.login.service

import banking.api.login.convertor.toUserIdentityEntity
import banking.api.login.domain.UserIdentity
import banking.api.login.domain.UserIdentityRequest
import banking.api.login.persistence.UserIdentityRepository
import banking.api.user.domain.UserProfileRequest
import banking.api.user.persistence.entity.UserProfileEntity
import org.springframework.stereotype.Service

@Service
class UserIdentityService(
    private val userIdentityRepository: UserIdentityRepository
) {
    fun findByUsername(username: String) = userIdentityRepository.findByUsername(username)

    fun findByUsernameAndPassword(username: String, password: String) = userIdentityRepository.findByUsernameAndPassword(username, password)

    fun save(userIdentity: UserIdentity) = userIdentityRepository.save(userIdentity.toUserIdentityEntity())

    fun validateUserIdentity(userIdentity: UserIdentity): Boolean {
        val loginCredentialEntity = findByUsernameAndPassword(userIdentity.username, userIdentity.password)
        return loginCredentialEntity != null
    }

    fun createUserIdentity(
        userProfile: UserProfileEntity,
        request: UserProfileRequest
    ) {
        save(
            UserIdentityRequest(
                userId = userProfile.id,
                username = request.username,
                password = request.password,
                confirmPassword = request.confirmPassword
            )
        )
    }
}