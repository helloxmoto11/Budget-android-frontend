package com.mypilog.data_remote.network.liability

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LiabilityService {

    @GET("/liabilities/all")
    suspend fun getAllLiabilities(@Query("uid") uid: Long): List<LiabilityApiModel>

    @POST("/liabilities")
    suspend fun saveLiability(@Body liabilityApiModel: LiabilityApiModel)
}