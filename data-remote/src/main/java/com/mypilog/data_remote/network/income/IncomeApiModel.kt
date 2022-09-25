package com.mypilog.data_remote.network.income

import com.squareup.moshi.Json

data class IncomeApiModel(
    @Json val id: Long = 0,
    @Json val name: String,
    @Json val type: String,
    @Json val amount: Double,
    @Json val uid: Long,
    @Json val date: String,
    @Json val timeStamp: String
)