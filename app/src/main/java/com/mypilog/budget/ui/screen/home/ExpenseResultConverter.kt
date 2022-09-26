package com.mypilog.budget.ui.screen.home

import android.util.Log
import com.mypilog.budget.state.ResultConverter
import com.mypilog.domain.usecase.budget.GetBudgetUseCase
import javax.inject.Inject

class ExpenseResultConverter @Inject constructor() : ResultConverter<GetBudgetUseCase.Response, BudgetModel>() {

    init {
        Log.d("convert", "converter: created")

    }

    override fun convertSuccess(response: GetBudgetUseCase.Response): BudgetModel {
        Log.d("convert", "convert:${response.budget}")

        return BudgetModel(
            expenses = response.budget.expenses,
            income = response.budget.income,
            assets = response.budget.assets,
            liabilities = response.budget.liabilities
        )
    }
}