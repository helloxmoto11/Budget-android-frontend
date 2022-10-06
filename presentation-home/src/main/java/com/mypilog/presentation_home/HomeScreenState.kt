package com.mypilog.presentation_home

import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.state.UiState


data class HomeScreenState(
    val errorMsg: String? = null,
    val selectedTab: BudgetType = BudgetType.Expenses,
    val uiState: UiState<BudgetModel>,
)


