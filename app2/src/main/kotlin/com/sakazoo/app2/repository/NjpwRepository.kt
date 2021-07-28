package com.sakazoo.app2.repository

import com.sakazoo.app2.model.Customer
import com.sakazoo.app2.model.Customers
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class NjpwRepository(private val restTemplate: RestTemplate) {
    fun getCustomers(): List<Customer> {
        val response = restTemplate.getForEntity("http://localhost:9091/external-app1/customers", Customers::class.java)
        return response.body?.customers ?: emptyList()
    }
}