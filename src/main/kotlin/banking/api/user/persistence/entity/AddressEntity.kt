package banking.api.user.persistence.entity

import banking.api.user.domain.AddressType
import banking.util.generateStringUUID
import banking.util.now
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "address")
data class AddressEntity(
    @Id
    val id: String = generateStringUUID(),
    @Enumerated(EnumType.STRING)
    val type: AddressType,
    val street: String,
    val city: String,
    val state: String,
    val zip: String,
    val country: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    val userProfile: UserProfileEntity,
    val createdAt: ZonedDateTime = now(),
    val modifyAt: ZonedDateTime = now(),

){
    override fun toString(): String {
        return "AddressEntity(id='$id', type=$type, street='$street', city='$city', state='$state', zip='$zip', country='$country', createdAt=$createdAt, modifyAt=$modifyAt)"
    }
}