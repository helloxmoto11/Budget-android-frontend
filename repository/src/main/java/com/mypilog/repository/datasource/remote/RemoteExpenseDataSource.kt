package com.mypilog.repository.datasource.remote

import com.mypilog.domain.entity.Expense
import kotlinx.coroutines.flow.Flow

interface RemoteExpenseDataSource {

    fun getExpenses(): Flow<List<Expense>>

    suspend fun addExpense(expense: Expense)
}