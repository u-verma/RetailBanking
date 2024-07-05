package banking.api.user.domain

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
class UserProfileResponse (
    val id: String,
    val userType: UserType,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val addresses: List<Address>,
    val dateOfBirth: String,
)