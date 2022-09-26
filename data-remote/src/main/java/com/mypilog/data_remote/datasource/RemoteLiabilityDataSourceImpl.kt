package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Liability
import com.mypilog.domain.entity.fakeLiabilities
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteLiabilityDataSourceImpl @Inject constructor(

) : RemoteLiabilityDataSource {
    override fun getAllLiabilities(): Flow<List<Liability>> = flow {
        emit(fakeLiabilities)
    }

    override fun getLiability(id: Long): Flow<Liability> {
        TODO("Not yet implemented")
    }

    override suspend fun saveLiability(liability: Liability) {
        TODO("Not yet implemented")
    }
}