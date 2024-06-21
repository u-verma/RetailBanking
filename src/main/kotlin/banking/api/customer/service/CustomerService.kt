package banking.api.customer.service

import banking.api.customer.convertor.toCustomerEntity
import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import banking.api.customer.persitence.repository.AddressRepository
import banking.api.customer.persitence.repository.CustomerRepository
import org.springframework.web.client.HttpClientErrorException.NotFound

class CustomerService {

    private val customerRepository = CustomerRepository()
    private val addressRepository = AddressRepository()

    fun registerCustomer(request: CustomerRequest): CustomerResponse {

        val customerEntity = request.toCustomerEntity()

        customerRepository.save(customerEntity)

        addressRepository.saveAll(customerEntity.addresses)

        return CustomerResponse(
            id = customerEntity.id,
            email = customerEntity.email,
        )
    }

    fun getAllCustomer(): List<CustomerResponse> {
        return customerRepository.findAll().map {
            CustomerResponse(
                id = it.id,
                email = it.email,
            )
        }
    }

    fun getCustomer(customerId: String): CustomerResponse {
        return customerRepository.findById(customerId)?.let {
            CustomerResponse(
                id = it.id,
                email = it.email,
            )
        } ?: throw RuntimeException("Customer not found")
    }
}