package com.sakazoo.app1.controller

import com.sakazoo.app1.model.Customer
import com.sakazoo.app1.service.App2Service
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/app1")
@RestController
class HelloController(private val app2Service: App2Service) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun hello(): ResponseEntity<String> {
        log.info("called hello api.")
        return ResponseEntity.ok("OK")
    }

    @GetMapping("/customers")
    fun customers(): ResponseEntity<CustomersResponse?> {
        val customerProfiles = app2Service.getCustomerProfiles()

        log.info("customers api called.")
        return if (customerProfiles == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        } else {
            ResponseEntity.ok(
                CustomersResponse(
                    groupName = customerProfiles.groupName,
                    customers = customerProfiles.customers.toResponse()
                )
            )
        }
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
    val groupName: String,
    val customers: List<CustomerResponse>
)

data class CustomerResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)