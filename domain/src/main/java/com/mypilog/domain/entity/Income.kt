package com.mypilog.domain.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Income(
    val id: Long = 0,
    val name: String,
    val category: String,
    val cost: Double,
    val uid: Long,
    val date: LocalDate,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)