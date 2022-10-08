package com.mypilog.repository

import android.util.Log
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import kotlinx.coroutines.flow.Flow

class ExpenseRepositoryImpl(
    private val remoteExpenseDataSource: RemoteExpenseDataSource,
): ExpenseRepository {

    companion object {
        private const val TAG = "ExpenseRepositoryImpl"
    }

    override fun getExpenses(): Flow<List<Expense>> =
        remoteExpenseDataSource.getExpenses()


    override fun getExpense(id: Long): Flow<Expense> {
        TODO("Not yet implemented")
    }

    override fun saveExpense(expense: Expense): Flow<Expense> {
        Log.d(TAG, "saveExpense: $expense")
       return remoteExpenseDataSource.saveExpense(expense)

    }
}