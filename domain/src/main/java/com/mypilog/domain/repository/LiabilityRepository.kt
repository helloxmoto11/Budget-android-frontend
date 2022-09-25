package com.mypilog.domain.repository

import com.mypilog.domain.entity.Liability
import kotlinx.coroutines.flow.Flow

interface LiabilityRepository {

    fun getLiabilities(): Flow<List<Liability>>
}