package com.mypilog.repository

import com.mypilog.domain.entity.Expense
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.repository.datasource.local.LocalExpenseDataSource
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import kotlinx.coroutines.flow.Flow

class ExpenseRepositoryImpl(
    private val remoteExpenseDataSource: RemoteExpenseDataSource,
    private val localExpenseDataSource: LocalExpenseDataSource
): ExpenseRepository {
    override fun getExpenses(): Flow<List<Expense>> {
        TODO("Not yet implemented")
    }

    override fun getExpense(id: Long): Flow<Expense> {
        TODO("Not yet implemented")
    }

    override fun saveExpense(expense: Expense): Expense {
        TODO("Not yet implemented")
    }
}