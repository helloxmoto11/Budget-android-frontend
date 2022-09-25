package com.mypilog.repository.datasource.remote

import com.mypilog.domain.entity.Income
import kotlinx.coroutines.flow.Flow

interface RemoteIncomeDataSource {

    fun getAllIncome(): Flow<List<Income>>

    fun getIncome(id: Long): Flow<Income>

    suspend fun saveIncome(income: Income)
}