package com.mypilog.domain.entity

data class Expense(
    val id: Long = 0,
    val name: String,
    val category: String,
    val cost: Double,
    val uid: Long,
    val date: String,
    val timeStamp: String
)

val fakeExpenses = listOf(
    Expense(id = 0, "Starbucks", "Food", 4.04, 56L, "2022-09-23", "now"),
    Expense(id = 1, "Gas", "Auto", 44.55, 56L, "2022-09-23", "now")
)
