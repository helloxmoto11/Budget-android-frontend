package com.mypilog.budget.ui.screen.home

import com.mypilog.domain.entity.*

data class BudgetModel(
    val expenses: List<Expense>,
    val income: List<Income>,
    val assets: List<Asset>,
    val liabilities: List<Liability>
)

val fakeBudgetModel = BudgetModel(
    expenses = fakeExpenses,
    income = fakeIncome,
    assets = fakeListOfAssets,
    liabilities = fakeLiabilities
)