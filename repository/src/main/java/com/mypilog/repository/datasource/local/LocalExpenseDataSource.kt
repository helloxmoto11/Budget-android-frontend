package com.mypilog.repository.datasource.local

import com.mypilog.domain.entity.Expense
import kotlinx.coroutines.flow.Flow

interface LocalExpenseDataSource {

    fun getExpenses(): Flow<List<Expense>>

    suspend fun addExpense(expense: Expense)
}