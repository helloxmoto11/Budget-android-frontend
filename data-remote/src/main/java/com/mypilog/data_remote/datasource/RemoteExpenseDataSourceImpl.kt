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
        emit(expenseService.getAllExpenses(56))
    }.map { expenses ->
        expenses.map { expenseApiModel ->
            convert(expenseApiModel)
        }
    }.catch {
        throw UseCaseException.ExpenseException(it)
    }

    override suspend fun saveExpense(expense: Expense): Expense? {
       return try {
           expenseService.saveExpense(expense.convertToApiModel())
           expense
       } catch (e: Exception) {
           e.printStackTrace()
           null
       }
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

    private fun Expense.convertToApiModel() : ExpenseApiModel{
        return ExpenseApiModel(
            id = id,
            name = name,
            category = category,
            cost = cost,
            uid = uid,
            date = date,
            timeStamp = timeStamp,
        )

    }
}