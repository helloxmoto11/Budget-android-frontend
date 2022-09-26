package com.mypilog.domain.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Income(
    val id: Long = 0,
    val name: String,
    val type: String,
    val amount: Double,
    val uid: Long,
    val date: String,
    val timeStamp: String
)

val fakeIncome = listOf(
    Income(
        id = 1,
        name = "End of month pay",
        type = "Pay",
        amount = 28000.00,
        uid = 56L,
        date = LocalDate.now().toString(),
        timeStamp = LocalDateTime.now().toString()
    ),
    Income(
        id = 2,
        name = "Mid month pay",
        type = "Pay",
        amount = 5500.00,
        uid = 56L,
        date = LocalDate.now().toString(),
        timeStamp = LocalDateTime.now().toString()
    )
)