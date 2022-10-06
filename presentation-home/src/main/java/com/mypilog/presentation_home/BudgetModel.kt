package com.mypilog.presentation_home

import com.mypilog.domain.entity.*

data class BudgetModel(
    val expenses: Map<String, List<Expense>>,
    val income: Map<String,List<Income>>,
    val assets: Map<String,List<Asset>>,
    val liabilities: Map<String,List<Liability>>
)

val fakeBudgetModel = BudgetModel(
    expenses = mapOf(Pair("2022-09-23", fakeExpenses)),
    income = mapOf(Pair("2022-09-23", fakeIncome)),
    assets = mapOf(Pair("2022-09-23", fakeListOfAssets)),
    liabilities = mapOf(Pair("2022-09-23", fakeLiabilities))
)