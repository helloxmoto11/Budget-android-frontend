package com.mypilog.data_remote.network.asset

import com.squareup.moshi.Json

data class AssetApiModel(
    @Json val id: Long = 0,
    @Json val name: String,
    @Json val type: String,
    @Json val value: Double,
    @Json val uid: Long,
    @Json val lastUpdated: String
)