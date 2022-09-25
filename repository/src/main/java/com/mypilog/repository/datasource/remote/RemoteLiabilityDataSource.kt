package com.mypilog.repository.datasource.remote

import com.mypilog.domain.entity.Liability
import kotlinx.coroutines.flow.Flow

interface RemoteLiabilityDataSource {

    fun getAllLiabilities(): Flow<List<Liability>>

    fun getLiability(id: Long): Flow<Liability>

    suspend fun saveLiability(liability: Liability)
}