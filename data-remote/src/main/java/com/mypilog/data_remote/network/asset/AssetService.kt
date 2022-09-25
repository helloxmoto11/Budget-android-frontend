package com.mypilog.data_remote.network.asset

import retrofit2.http.GET
import retrofit2.http.Query

interface AssetService {

    @GET("/assets/all")
    suspend fun getExpenses(@Query("uid") uid: Long): List<AssetApiModel>
}