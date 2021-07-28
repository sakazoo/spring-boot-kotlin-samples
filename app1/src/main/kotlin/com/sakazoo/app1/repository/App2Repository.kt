package com.sakazoo.app1.repository

import com.sakazoo.app1.model.CustomerProfiles
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class App2Repository(private val restTemplate: RestTemplate) {
    fun customerProfiles(): CustomerProfiles? {
        val response = restTemplate.getForEntity("http://localhost:8082/app2/customers", CustomerProfiles::class.java)
        return response.body
    }
}