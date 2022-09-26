package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Asset
import com.mypilog.domain.entity.fakeListOfAssets
import com.mypilog.repository.datasource.remote.RemoteAssetDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime
import javax.inject.Inject

class RemoteAssetDataSourceImpl @Inject constructor(

) : RemoteAssetDataSource {
    override fun getAllAssets(): Flow<List<Asset>> = flow {

        emit(fakeListOfAssets)
    }

    override fun getAsset(id: Long): Flow<Asset> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAsset(asset: Asset) {
        TODO("Not yet implemented")
    }
}