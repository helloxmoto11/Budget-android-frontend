package com.mypilog.repository

import com.mypilog.domain.entity.Expense
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class ExpenseRepositoryImpl(
    private val remoteExpenseDataSource: RemoteExpenseDataSource,
): ExpenseRepository {

    override fun getExpenses(): Flow<List<Expense>> =
        remoteExpenseDataSource.getExpenses()


    override fun getExpense(id: Long): Flow<Expense> {
        TODO("Not yet implemented")
    }

    override fun saveExpense(expense: Expense): Flow<Expense> = flow {
        remoteExpenseDataSource.saveExpense(expense)
    }
}