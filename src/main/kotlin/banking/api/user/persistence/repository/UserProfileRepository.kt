package banking.api.user.persistence.repository

import banking.api.user.persistence.entity.UserProfileEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProfileRepository : CrudRepository<UserProfileEntity, String>{
    fun findByEmail(email: String): UserProfileEntity
}
