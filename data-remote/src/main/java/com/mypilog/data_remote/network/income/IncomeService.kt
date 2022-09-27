package com.mypilog.data_remote.network.income

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IncomeService {

    @GET("/income/all")
    suspend fun getAllIncome(@Query("uid") uid: Long): List<IncomeApiModel>

    @GET("/income")
    suspend fun getIncome(@Query("id") id: Long, @Query("uid") uid: Long): IncomeApiModel

    @POST("/income")
    suspend fun saveIncome(@Body incomeApiModel: IncomeApiModel): IncomeApiModel
}