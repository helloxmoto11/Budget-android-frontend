package com.mypilog.data_remote.datasource

import android.util.Log
import com.mypilog.data_remote.network.asset.AssetApiModel
import com.mypilog.data_remote.network.asset.AssetService
import com.mypilog.domain.entity.Asset
import com.mypilog.domain.entity.UseCaseException.AssetException
import com.mypilog.repository.datasource.remote.RemoteAssetDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteAssetDataSourceImpl @Inject constructor(
    private val assetService: AssetService
) : RemoteAssetDataSource {
    override fun getAllAssets(): Flow<List<Asset>> = flow {
        emit(assetService.getExpenses(56))
    }.map {
        it.map { apiModel ->
            convert(apiModel)
        }
    }.catch {
        Log.d("DataSource", "getAllAssets: ${it.stackTrace}")
        throw AssetException(it)
    }

    override fun getAsset(id: Long): Flow<Asset> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAsset(asset: Asset) {
        TODO("Not yet implemented")
    }

    private fun convert(apiModel: AssetApiModel): Asset {
        return Asset(
            id = apiModel.id,
            name = apiModel.name,
            type = apiModel.type,
            value = apiModel.value,
            uid = apiModel.uid,
            lastUpdated = apiModel.lastUpdated
        )
    }
}