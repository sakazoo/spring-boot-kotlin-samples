package com.sakazoo.externalapp1.service

import com.sakazoo.externalapp1.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {
    fun getCustomers(): List<Customer> {
        val nagata = Customer(
            id = 1,
            firstName = "yuji",
            lastName = "nagata",
            age = 53
        )
        val naito = Customer(
            id = 2,
            firstName = "tetsuya",
            lastName = "naito",
            age = 39
        )

        return listOf(nagata, naito)
    }
}