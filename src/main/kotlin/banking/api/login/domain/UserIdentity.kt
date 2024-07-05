package banking.api.login.domain

interface UserIdentity {
    val userId: String?
    val username: String
    val password: String
    val confirmPassword: String?
}

data class UserIdentityRequest(
    override val userId: String? = null,
    override val username: String,
    override val password: String,
    override val confirmPassword: String? = null
) : UserIdentity
