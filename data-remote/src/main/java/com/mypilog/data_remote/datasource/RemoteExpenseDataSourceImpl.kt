package com.mypilog.data_remote.datasource

import android.util.Log
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

//        Log.d("Expenses", "getExpenses: ")
//        val list = listOf(
//            Expense(
//                category = "Home",
//                date = LocalDate.now(),
//                uid = 1L,
//                name = "Rent",
//                cost = 1400.0
//            ),
//            Expense(
//                category = "Auto",
//                date = LocalDate.now(),
//                uid = 1L,
//                name = "Car Payment",
//                cost = 500.0
//            ),
//            Expense(
//                category = "Food",
//                date = LocalDate.now(),
//                uid = 1L,
//                name = "Chipotle",
//                cost = 1400.0
//            ),
//        )
//        emit(list)


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