package banking.api.user.persistence.repository

import banking.api.user.persistence.entity.AddressEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CrudRepository<AddressEntity, String>