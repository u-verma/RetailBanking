package banking.api.customer.controller

import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import banking.api.customer.service.CustomerService
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController: CustomerResource{

    val customerService = CustomerService()
    override fun registerCustomer(request: CustomerRequest): CustomerResponse {
        return customerService.registerCustomer(request)
    }
}