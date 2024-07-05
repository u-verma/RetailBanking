package banking.api.login.persistence

import org.springframework.data.repository.CrudRepository

interface UserIdentityRepository: CrudRepository<UserIdentityEntity, String>{
    fun findByUsername(username: String): UserIdentityEntity?
    fun findByUsernameAndPassword(username: String, password: String): UserIdentityEntity?
}