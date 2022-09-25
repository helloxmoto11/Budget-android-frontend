package com.mypilog.domain.repository

import com.mypilog.domain.entity.Asset
import kotlinx.coroutines.flow.Flow

interface AssetRepository {

    fun getAssets(): Flow<List<Asset>>
}