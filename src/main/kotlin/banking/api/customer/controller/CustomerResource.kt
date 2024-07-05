package banking.api.customer.controller

import banking.api.customer.controller.CustomerResource.Companion.CUSTOMER_ENDPOINT
import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping(CUSTOMER_ENDPOINT)
@CrossOrigin(origins = ["http://localhost:5173"])
interface CustomerResource {

    companion object {
        const val CUSTOMER_ENDPOINT = "/api/v1/customer"
    }

    @PostMapping("/register", consumes = ["application/json"], produces = ["application/json"])
    @ResponseStatus(OK)
    @ResponseBody
    fun registerCustomer(@RequestBody request: CustomerRequest): CustomerResponse


    @GetMapping()
    @ResponseStatus(OK)
    @ResponseBody
    fun getAllCustomer(): List<CustomerResponse>

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    fun getCustomer(@PathVariable("id") customerId: String ): CustomerResponse

    @GetMapping("/search")
    @ResponseStatus(OK)
    @ResponseBody
    fun getCustomerByName(@RequestParam name: String): CustomerResponse

}