package banking.api.user.domain

import banking.api.login.domain.UserIdentity
import banking.util.generateStringUUID
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


interface UserProfile {
    val userType: UserType
    val firstName: String
    val lastName: String
    val email: String
    val phone: String
    val addresses: List<Address>
    val dateOfBirth: String
}

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
data class UserProfileRequest(
    override val userId: String = generateStringUUID(),
    override val username: String,
    override val password: String,
    override val confirmPassword: String,
    override val userType: UserType,
    override val firstName: String,
    override val lastName: String,
    override val email: String,
    override val phone: String,
    override val addresses: List<Address>,
    override val dateOfBirth: String
): UserIdentity, UserProfile

data class Address(
    val type: AddressType,
    val street: String,
    val city: String,
    val state: String,
    val zip: String,
    val country: String,
)

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
data class UpdateUserProfileRequest(
    override val userType: UserType,
    override val firstName: String,
    override val lastName: String,
    override val email: String,
    override val phone: String,
    override val addresses: List<Address>,
    override val dateOfBirth: String
): UserProfile