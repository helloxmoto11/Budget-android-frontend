package com.mypilog.presentation_add.liability

import java.time.LocalDate

data class AddLiabilityScreenState(
    val liability: String = "",
    val balance: Double = 0.0,
    val date: String = LocalDate.now().toString()
)