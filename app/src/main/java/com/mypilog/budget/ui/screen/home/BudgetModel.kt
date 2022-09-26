package com.mypilog.budget.ui.screen.home

import com.mypilog.domain.entity.Asset
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.entity.Income
import com.mypilog.domain.entity.Liability

data class BudgetModel(
    val expenses: List<Expense>,
    val income: List<Income>,
    val assets: List<Asset>,
    val liabilities: List<Liability>
)