package banking.api.customer.service

import banking.api.customer.convertor.toCustomerEntity
import banking.api.customer.convertor.toCustomerResponse
import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import banking.api.customer.persitence.entity.CustomerEntity
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

        return customerEntity.toCustomerResponse()
    }

    fun getAllCustomer(): List<CustomerResponse> {
        return customerRepository.findAll().map { it.toCustomerResponse() }
    }

    fun getCustomer(customerId: String): CustomerResponse {
        return customerRepository.findById(customerId)?.let { it.toCustomerResponse() } ?: throw RuntimeException("Customer not found")
    }

    fun getCustomerByName(name: String): CustomerResponse {
        return customerRepository.findByName(name).firstOrNull()?.toCustomerResponse() ?: throw java.lang.RuntimeException("Customer not found")
    }
}
