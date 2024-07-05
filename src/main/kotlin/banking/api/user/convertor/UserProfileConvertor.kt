package banking.api.user.convertor

import banking.api.user.domain.Address
import banking.api.user.domain.UserProfileRequest
import banking.api.user.domain.UserProfileResponse
import banking.api.user.persistence.entity.AddressEntity
import banking.api.user.persistence.entity.UserProfileEntity
import banking.util.now
import banking.util.toLocalDate
import banking.util.toZoneDateTimeFromMilli

fun UserProfileRequest.toUserProfileEntity(): UserProfileEntity {
    val userProfileEntity =  UserProfileEntity(
        id = userId,
        type = userType,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone,
        dateOfBirth = dateOfBirth.toLocalDate(),
        modifyAt = now(),
        createdAt = now(),
    )
    this.addresses.forEach {
        userProfileEntity.addresses.add(it.toAddressEntity(userProfileEntity))
    }
    return userProfileEntity
}

fun Address.toAddressEntity(userProfileEntity: UserProfileEntity) =
    AddressEntity(
        type = type,
        street = street,
        city = city,
        state = state,
        zip = zip,
        country = country,
        userProfile = userProfileEntity,
    )

fun UserProfileEntity.userResponse() = UserProfileResponse(
    id = this.id,
    userType = this.type,
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email,
    phone = this.phone,
    dateOfBirth = this.dateOfBirth.toString(),
    addresses = this.addresses.map {
        Address(
            type = it.type,
            street = it.street,
            city = it.city,
            state = it.state,
            zip = it.zip,
            country = it.country,
        )
    },
)