package com.mypilog.data_remote.datasource

import android.util.Log
import com.mypilog.domain.entity.Expense
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate
import javax.inject.Inject

class RemoteExpenseDataSourceImpl @Inject constructor() : RemoteExpenseDataSource {

    override fun getExpenses(): Flow<List<Expense>> = flow {
        Log.d("Expenses", "getExpenses: ")
        val list = listOf(
            Expense(
                category = "Home",
                date = LocalDate.now(),
                uid = 1L,
                name = "Rent",
                cost = 1400.0
            ),
            Expense(
                category = "Auto",
                date = LocalDate.now(),
                uid = 1L,
                name = "Car Payment",
                cost = 500.0
            ),
            Expense(
                category = "Food",
                date = LocalDate.now(),
                uid = 1L,
                name = "Chipotle",
                cost = 1400.0
            ),
        )
        emit(list)
    }

    override suspend fun addExpense(expense: Expense) {
        TODO("Not yet implemented")
    }
}