package com.mypilog.data_remote.network.liability

import retrofit2.http.GET
import retrofit2.http.Query

interface LiabilityService {

    @GET("/liabilities/all")
    suspend fun getAllLiabilities(@Query("uid") uid: Long): List<LiabilityApiModel>
}