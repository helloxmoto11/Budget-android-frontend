package com.mypilog.domain.repository

import com.mypilog.domain.entity.Income
import kotlinx.coroutines.flow.Flow

interface IncomeRepository {

    fun getAllIncome(): Flow<List<Income>>
}