package com.mypilog.domain.usecase.expense

import com.mypilog.domain.entity.Expense
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetExpensesUseCase(
    configuration: Configuration,
    private val expenseRepository: ExpenseRepository
): UseCase<GetExpensesUseCase.Request, GetExpensesUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> {
        return expenseRepository.getExpenses()
            .map {
                Response(it)
            }
    }
    object Request : UseCase.Request
    data class Response(val expenses: List<Expense>): UseCase.Response
}