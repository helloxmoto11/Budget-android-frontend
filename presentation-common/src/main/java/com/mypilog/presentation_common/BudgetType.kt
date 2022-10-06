package com.mypilog.presentation_common

sealed class BudgetType(val name: String) {
    object Expenses : BudgetType("Expenses")
    object Income : BudgetType("Income")
    object Assets : BudgetType("Assets")
    object Liabilities : BudgetType("Liabilities")

}