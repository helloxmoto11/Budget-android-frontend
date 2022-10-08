package com.mypilog.domain.usecase.expense

import android.util.Log
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AddExpenseUseCase @Inject constructor(
    configuration: Configuration,
    private val expenseRepository: ExpenseRepository
) : UseCase<AddExpenseUseCase.Request, AddExpenseUseCase.Response>(configuration) {
    companion object {
        private const val TAG = "AddExpenseUseCase"
    }

    override fun process(request: Request): Flow<Response> {
        Log.d(TAG, "process: ${request.expense}")
        return expenseRepository.saveExpense(request.expense)
            .map {
                Response(it)
            }
    }


    class Request(val expense: Expense) : UseCase.Request

    class Response(val expense: Expense) : UseCase.Response


}