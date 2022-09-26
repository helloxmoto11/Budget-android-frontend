package com.mypilog.domain.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Income(
    val id: Long = 0,
    val name: String,
    val category: String,
    val amount: Double,
    val uid: Long,
    val date: LocalDate,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)

val fakeIncome = listOf(
    Income(
        id = 1,
        name = "End of month pay",
        category = "Pay",
        amount = 28000.00,
        uid = 56L,
        date = LocalDate.now()
    ),
    Income(
        id = 2,
        name = "Mid month pay",
        category = "Pay",
        amount = 5500.00,
        uid = 56L,
        date = LocalDate.now()
    )
)