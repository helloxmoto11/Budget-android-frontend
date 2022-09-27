package com.mypilog.data_remote.datasource

import com.mypilog.data_remote.network.liability.LiabilityApiModel
import com.mypilog.data_remote.network.liability.LiabilityService
import com.mypilog.domain.entity.Liability
import com.mypilog.domain.entity.UseCaseException
import com.mypilog.domain.entity.fakeLiabilities
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteLiabilityDataSourceImpl @Inject constructor(
    private val liabilityService: LiabilityService
) : RemoteLiabilityDataSource {
    override fun getAllLiabilities(): Flow<List<Liability>> = flow {
        emit(liabilityService.getAllLiabilities(56L))
    }.map {
        it.map { apiModel ->
            convert(apiModel)
        }
    }.catch { throw UseCaseException.LiabilityException(it) }

    override fun getLiability(id: Long): Flow<Liability> {
        TODO("Not yet implemented")
    }

    override suspend fun saveLiability(liability: Liability) {
        TODO("Not yet implemented")
    }

    private fun convert(apiModel: LiabilityApiModel): Liability {
        return Liability(
            id = apiModel.id,
            name = apiModel.name,
            type = apiModel.type,
            balance = apiModel.balance,
            uid = apiModel.uid,
            lastUpdated = apiModel.lastUpdated
        )
    }
}