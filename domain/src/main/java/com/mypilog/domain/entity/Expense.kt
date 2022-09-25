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
