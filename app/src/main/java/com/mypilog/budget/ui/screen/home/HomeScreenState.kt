package com.mypilog.budget.ui.screen.home

import com.mypilog.domain.entity.Expense

data class HomeScreenState(
    val errorMsg: String? = null,
    val isLoading: Boolean = false,
    val expenses: List<Expense> = emptyList()
)