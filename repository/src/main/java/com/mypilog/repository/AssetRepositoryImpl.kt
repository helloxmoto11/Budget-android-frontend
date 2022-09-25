package com.mypilog.repository

import com.mypilog.domain.entity.Asset
import com.mypilog.domain.repository.AssetRepository
import com.mypilog.repository.datasource.remote.RemoteAssetDataSource
import kotlinx.coroutines.flow.Flow

class AssetRepositoryImpl(
    private val remoteAssetDataSource: RemoteAssetDataSource
) : AssetRepository{
    override fun getAssets(): Flow<List<Asset>> =
        remoteAssetDataSource.getAllAssets()


}