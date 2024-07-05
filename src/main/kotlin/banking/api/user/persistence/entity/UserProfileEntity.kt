package banking.api.user.persistence.entity

import banking.api.user.domain.UserType
import banking.util.generateStringUUID
import banking.util.now
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.ZonedDateTime

@Entity
@Table(name = "user_profile")
data class UserProfileEntity(
    @Id
    val id: String = generateStringUUID(),
    @Enumerated(EnumType.STRING)
    val type: UserType,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val dateOfBirth: LocalDate,
    @OneToMany(mappedBy = "userProfile", cascade = [CascadeType.ALL], orphanRemoval = true)
    val addresses: MutableList<AddressEntity> = mutableListOf(),
    val createdAt: ZonedDateTime = now(),
    val modifyAt: ZonedDateTime = now(),
){
    override fun toString(): String {
        return "UserEntity(id='$id', userType=$type, firstName='$firstName', lastName='$lastName', email='$email', phone='$phone', dateOfBirth=$dateOfBirth, createdAt=$createdAt, modifyAt=$modifyAt)"
    }
}