package com.sakazoo.externalapp1.controller

import com.sakazoo.externalapp1.model.Customer
import com.sakazoo.externalapp1.service.CustomerService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/external-app1")
@RestController
class CustomerController(private val customerService: CustomerService) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping("/customers")
    fun customers(): ResponseEntity<CustomersResponse> {
        val customers = customerService.getCustomers()

        log.info("customers api called.")
        return ResponseEntity.ok(
            CustomersResponse(customers.toResponse())
        )
    }

    private fun List<Customer>.toResponse() = map {
        CustomerResponse(
            id = it.id,
            firstName = it.firstName,
            lastName = it.lastName,
            age = it.age
        )
    }
}

data class CustomersResponse(
    val customers: List<CustomerResponse>
)

data class CustomerResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)