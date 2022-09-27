package com.mypilog.domain.entity

import java.time.LocalDateTime

data class Liability(
    val id: Long = 0,
    val name: String,
    val type: String,
    val balance: Double,
    val uid: Long,
    val lastUpdated: String = LocalDateTime.now().toString()
)


val fakeLiabilities = listOf(
    Liability(id = 1, name = "Car", type = "Auto Loan", balance = 4000.00, uid = 56L),
    Liability(id = 2, name = "House Payment", type = "Housing", balance = 350000.00, uid = 56L)
)
