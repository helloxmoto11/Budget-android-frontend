package com.mypilog.domain.entity

data class Budget(
    val expenses: List<Expense>,
    val income: List<Income>,
    val assets: List<Asset>,
    val liabilities: List<Liability>
)
