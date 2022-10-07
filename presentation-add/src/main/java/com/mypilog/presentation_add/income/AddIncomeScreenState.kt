package com.mypilog.presentation_add.income

import java.time.LocalDate

data class AddIncomeScreenState(
    val income: String = "",
    val type: String = "",
    val amount: Double = 0.0,
    val date: String = LocalDate.now().toString()
)