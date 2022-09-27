package com.mypilog.domain.entity

import java.time.LocalDateTime

data class Asset(
   val id: Long = 0,
    val name: String,
    val type: String,
    val value: Double,
    val uid: Long,
    val lastUpdated: String
)

val fakeListOfAssets = listOf(
 Asset(
  id = 1,
  name = "VTSAX",
  type = "Retirement",
  value = 64444.34,
  uid = 56L,
  lastUpdated = LocalDateTime.now().toString()
 ),
 Asset(
  id = 2,
  name = "Ally",
  type = "Savings",
  value = 60000.11,
  uid = 56L,
  lastUpdated = LocalDateTime.now().toString()
 ),
)
