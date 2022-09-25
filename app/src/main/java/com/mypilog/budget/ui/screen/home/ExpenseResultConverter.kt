package com.mypilog.budget.ui.screen.home

import android.util.Log
import com.mypilog.budget.state.ResultConverter
import com.mypilog.domain.usecase.expense.GetExpensesUseCase
import javax.inject.Inject

class ExpenseResultConverter @Inject constructor() : ResultConverter<GetExpensesUseCase.Response, ExpenseModel>() {

    init {
        Log.d("convert", "converter: created")

    }

    override fun convertSuccess(data: GetExpensesUseCase.Response): ExpenseModel {
        Log.d("convert", "convert:${data.expenses}")

        return ExpenseModel(
            expenses = data.expenses
        )
    }
}