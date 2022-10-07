package com.mypilog.presentation_add

import androidx.compose.runtime.Composable
import com.mypilog.presentation_add.asset.AddAssetScreen
import com.mypilog.presentation_add.expense.AddExpenseScreen
import com.mypilog.presentation_add.income.AddIncomeScreen
import com.mypilog.presentation_add.liability.AddLiabilityScreen
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.ScreenType

@Composable
fun AddScreen(
    screenType: ScreenType,
    type: BudgetType
) {

  when (type) {
      BudgetType.Assets -> AddAssetScreen()
      BudgetType.Expenses -> AddExpenseScreen(screenType = screenType)
      BudgetType.Income -> AddIncomeScreen()
      BudgetType.Liabilities -> AddLiabilityScreen()
  }

}

