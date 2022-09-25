package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Liability
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteLiabilityDataSourceImpl @Inject constructor(

): RemoteLiabilityDataSource {
    override fun getAllLiabilities(): Flow<List<Liability>> {
        TODO("Not yet implemented")
    }

    override fun getLiability(id: Long): Flow<Liability> {
        TODO("Not yet implemented")
    }

    override suspend fun saveLiability(liability: Liability) {
        TODO("Not yet implemented")
    }
}