package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Asset
import com.mypilog.repository.datasource.remote.RemoteAssetDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime
import javax.inject.Inject

class RemoteAssetDataSourceImpl @Inject constructor(

) : RemoteAssetDataSource {
    override fun getAllAssets(): Flow<List<Asset>> = flow {
        val fakeListOfAssets = listOf(
            Asset(
                id = 1,
                name = "VTSAX",
                type = "Retirement",
                value = 64444.34,
                uid = 56L,
                lastUpdated = LocalDateTime.now()
            ),
            Asset(
                id = 2,
                name = "Ally",
                type = "Savings",
                value = 60000.11,
                uid = 56L,
                lastUpdated = LocalDateTime.now()
            ),
        )
        emit(fakeListOfAssets)
    }

    override fun getAsset(id: Long): Flow<Asset> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAsset(asset: Asset) {
        TODO("Not yet implemented")
    }
}