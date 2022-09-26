package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Liability
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteLiabilityDataSourceImpl @Inject constructor(

) : RemoteLiabilityDataSource {
    override fun getAllLiabilities(): Flow<List<Liability>> = flow {
        val fakeLiabilities = listOf(
            Liability(id = 1, name = "Car", type = "Auto Loan", balance = 4000.00, uid = 56L),
            Liability(id = 2, name = "House Payment", type = "Housing", balance = 350000.00, uid = 56L)
        )
        emit(fakeLiabilities)
    }

    override fun getLiability(id: Long): Flow<Liability> {
        TODO("Not yet implemented")
    }

    override suspend fun saveLiability(liability: Liability) {
        TODO("Not yet implemented")
    }
}