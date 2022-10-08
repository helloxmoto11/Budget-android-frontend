package com.mypilog.data_remote.network.expense

import com.squareup.moshi.Json

data class ExpenseApiModel(
     @Json val id: Long = 0,
     @Json val name: String,
     @Json val category: String,
     @Json val cost: Double,
     @Json val uid: Long,
     @Json val date: String,
     @Json val serverTimeStamp: String? = null
) {
}