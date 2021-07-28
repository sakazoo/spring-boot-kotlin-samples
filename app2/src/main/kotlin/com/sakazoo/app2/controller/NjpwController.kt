package com.sakazoo.app2.controller

import com.sakazoo.app2.model.Customer
import com.sakazoo.app2.service.NjpwService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/app2")
@RestController
class NjpwController(private val njpwService: NjpwService) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        private const val GROUP_NAME = "NJPW"
    }

    @GetMapping("/customers")
    fun customers(): ResponseEntity<CustomersResponse> {
        val customers = njpwService.getCustomers()
        val matchVenues = njpwService.getMatchVenues()

        log.info("customers api called.")
        return ResponseEntity.ok(
            CustomersResponse(
                groupName = GROUP_NAME,
                customers = customers.toResponse()
            )
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
    val groupName: String,
    val customers: List<CustomerResponse>
)

data class CustomerResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)