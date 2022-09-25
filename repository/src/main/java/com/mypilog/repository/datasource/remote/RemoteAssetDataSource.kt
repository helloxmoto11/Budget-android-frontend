package com.mypilog.repository.datasource.remote

import com.mypilog.domain.entity.Asset
import kotlinx.coroutines.flow.Flow

interface RemoteAssetDataSource {

    fun getAllAssets(): Flow<List<Asset>>

    fun getAsset(id: Long): Flow<Asset>

    suspend fun saveAsset(asset: Asset)
}