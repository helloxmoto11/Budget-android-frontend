package com.mypilog.domain.entity

data class User(
    val uid: Long = 0,
    val email: String,
    val firstName: String,
    val lastName: String,
)
