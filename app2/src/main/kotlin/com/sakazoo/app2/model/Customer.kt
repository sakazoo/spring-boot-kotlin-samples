package com.sakazoo.app2.model

data class Customer(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Int
)

data class Customers(
    val customers: List<Customer>
)