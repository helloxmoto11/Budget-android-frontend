package com.mypilog.data_remote.network.liability

import com.squareup.moshi.Json

data class LiabilityApiModel(
    @Json val id: Long = 0,
    @Json val name: String,
    @Json val type: String,
    @Json val balance: Double,
    @Json val uid: Long,
    @Json val lastUpdated: String
)