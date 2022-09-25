package com.mypilog.repository

import com.mypilog.domain.entity.Liability
import com.mypilog.domain.repository.LiabilityRepository
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import kotlinx.coroutines.flow.Flow

class LiabilityRepositoryImpl(
    private val remoteLiabilityDataSource: RemoteLiabilityDataSource
) : LiabilityRepository{
    override fun getLiabilities(): Flow<List<Liability>> =
        remoteLiabilityDataSource.getAllLiabilities()


}