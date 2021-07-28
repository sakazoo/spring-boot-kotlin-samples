package com.sakazoo.app1.model

data class CustomerProfiles(
    val groupName: String,
    val customers: List<Customer>
)

data class Customer(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)