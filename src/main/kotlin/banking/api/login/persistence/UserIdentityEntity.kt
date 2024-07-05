package banking.api.login.persistence

import banking.util.now
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "user_identity")
data class UserIdentityEntity (
    @Id
    val userId: String,
    val username: String,
    val password: String,
    val confirmPassword: String,
    val createdAt: ZonedDateTime = now(),
    val modifyAt: ZonedDateTime = now(),
)