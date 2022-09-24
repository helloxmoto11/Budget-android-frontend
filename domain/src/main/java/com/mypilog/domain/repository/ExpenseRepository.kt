package com.mypilog.domain.repository

import com.mypilog.domain.entity.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun getExpenses(): Flow<List<Expense>>

    fun getExpense(id: Long): Flow<Expense>

    fun saveExpense(expense: Expense): Expense
}