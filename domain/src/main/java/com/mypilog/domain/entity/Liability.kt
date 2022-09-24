package com.mypilog.domain.entity

import java.time.LocalDateTime

data class Liability(
    val id: Long = 0,
    val name: String,
    val type: String,
    val balance: Double,
    val uid: Long,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)
