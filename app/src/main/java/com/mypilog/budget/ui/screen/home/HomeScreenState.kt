package com.mypilog.budget.ui.screen.home

import com.mypilog.budget.state.UiState

data class HomeScreenState(
    val errorMsg: String? = null,
    val selectedTab: BudgetType = BudgetType.Expenses,
    val uiState: UiState<BudgetModel>,
)

sealed class BudgetType(val name: String) {
    object Expenses : BudgetType("Expenses")
    object Income : BudgetType("Income")
    object Assets : BudgetType("Assets")
    object Liabilities : BudgetType("Liabilities")

}
