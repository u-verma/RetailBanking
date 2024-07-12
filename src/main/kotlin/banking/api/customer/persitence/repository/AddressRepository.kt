package banking.api.customer.persitence.repository

import banking.api.customer.persitence.entity.AddressEntity
import banking.api.customer.persitence.entity.CustomerEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class AddressRepository {

    private val AddressDatabase = ConcurrentHashMap<String, AddressEntity>()

    fun save(addressEntity: AddressEntity) {
        AddressDatabase[addressEntity.id] = addressEntity
    }

    fun saveAll(addressEntities: List<AddressEntity>) {
        addressEntities.forEach { save(it) }
    }

    fun findById(id: String): AddressEntity? {
        return AddressDatabase[id]
    }

    fun findAll(): List<AddressEntity> {
        return AddressDatabase.values.toList()
    }
}