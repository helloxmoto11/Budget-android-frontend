package com.mypilog.budget.ui.screen.home

import com.mypilog.budget.state.UiState
import com.mypilog.domain.entity.Expense

data class HomeScreenState(
    val errorMsg: String? = null,
    val uiState: UiState<ExpenseModel>,
    val expenses: List<Expense> = emptyList()
)