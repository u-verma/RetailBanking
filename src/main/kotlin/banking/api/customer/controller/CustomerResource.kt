package banking.api.customer.controller

import banking.api.customer.controller.CustomerResource.Companion.CUSTOMER_ENDPOINT
import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping(CUSTOMER_ENDPOINT)
interface CustomerResource {

    companion object {
        const val CUSTOMER_ENDPOINT = "/api/v1/customer"
    }

    @PostMapping("/register")
    @ResponseStatus(OK)
    @ResponseBody
    fun registerCustomer(@RequestBody request: CustomerRequest): CustomerResponse
}