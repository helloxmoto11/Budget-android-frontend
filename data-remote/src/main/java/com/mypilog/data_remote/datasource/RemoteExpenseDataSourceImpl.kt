package com.mypilog.data_remote.datasource

import com.mypilog.data_remote.network.expense.ExpenseApiModel
import com.mypilog.data_remote.network.expense.ExpenseService
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.entity.UseCaseException
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteExpenseDataSourceImpl @Inject constructor(
    private val expenseService: ExpenseService
) : RemoteExpenseDataSource {

    override fun getExpenses(): Flow<List<Expense>> = flow {
        emit(expenseService.getExpenses(56))
    }.map { expenses ->
        expenses.map { expenseApiModel ->
            convert(expenseApiModel)
        }
    }.catch {
        throw UseCaseException.ExpenseException(it)
    }

    override suspend fun addExpense(expense: Expense) {
        TODO("Not yet implemented")
    }

    private fun convert(expenseApiModel: ExpenseApiModel) =
        Expense(
            id = expenseApiModel.id,
            name = expenseApiModel.name,
            category = expenseApiModel.category,
            cost = expenseApiModel.cost,
            uid = expenseApiModel.uid,
            date = expenseApiModel.date,
            timeStamp = expenseApiModel.timeStamp,
        )
}