package com.mypilog.repository

import com.mypilog.domain.entity.Income
import com.mypilog.domain.repository.IncomeRepository
import com.mypilog.repository.datasource.remote.RemoteIncomeDataSource
import kotlinx.coroutines.flow.Flow

class IncomeRepositoryImpl(
    private val remoteIncomeDataSource: RemoteIncomeDataSource
): IncomeRepository {
    override fun getAllIncome(): Flow<List<Income>> =
        remoteIncomeDataSource.getAllIncome()
}