package com.mypilog.presentation_add.expense

import com.mypilog.domain.entity.Expense
import com.mypilog.domain.usecase.expense.AddExpenseUseCase
import com.mypilog.presentation_common.state.ResultConverter
import javax.inject.Inject

class ExpenseResultConverter @Inject constructor() :
    ResultConverter<AddExpenseUseCase.Response, Expense>() {

    override fun convertSuccess(response: AddExpenseUseCase.Response): Expense {
        return response.expense
    }
}