package com.mypilog.domain.entity

import java.time.LocalDateTime

data class Asset(
   val id: Long = 0,
    val name: String,
    val type: String,
    val value: Double,
    val uid: Long,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)
