package banking.api.customer.controller

import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import banking.api.customer.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    val customerService:CustomerService
): CustomerResource{

    override fun registerCustomer(request: CustomerRequest): CustomerResponse {
        return customerService.registerCustomer(request)
    }

    override fun getAllCustomer(): List<CustomerResponse> {
        return customerService.getAllCustomer()
    }

    override fun getCustomer(customerId: String): CustomerResponse {
        return customerService.getCustomer(customerId)
    }

    override fun getCustomerByName(name: String): CustomerResponse {
        return customerService.getCustomerByName(name)
    }

}