package com.sakazoo.app1.service

import com.sakazoo.app1.repository.App2Repository
import org.springframework.stereotype.Service

@Service
class App2Service(private val app2Repository: App2Repository) {
    fun getCustomerProfiles() = app2Repository.customerProfiles()
}