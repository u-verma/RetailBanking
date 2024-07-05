package banking.api.login.convertor

import banking.api.login.domain.UserIdentity
import banking.api.login.persistence.UserIdentityEntity

fun UserIdentity.toUserIdentityEntity(): UserIdentityEntity {
    return UserIdentityEntity(
        userId = userId!!,
        username = username,
        password = password,
        confirmPassword = confirmPassword!!
    )
}