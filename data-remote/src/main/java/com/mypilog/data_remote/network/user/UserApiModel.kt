package com.mypilog.data_remote.network.user

import com.squareup.moshi.Json

data class UserApiModel (
    @Json val uid: Long = 0,
    @Json val email: String,
    @Json val firstName: String,
    @Json val lastName: String,
    @Json val createdAt: String,
    @Json val lastUpdated: String
)