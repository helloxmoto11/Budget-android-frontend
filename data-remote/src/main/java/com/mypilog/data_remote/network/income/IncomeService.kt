package com.mypilog.data_remote.network.income

import retrofit2.http.GET
import retrofit2.http.Query

interface IncomeService {

    @GET("/income/all")
    suspend fun getAllIncome(@Query("uid") uid: Long): List<IncomeApiModel>
}