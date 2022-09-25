package com.mypilog.data_remote.network.expense

import retrofit2.http.GET
import retrofit2.http.Query

interface ExpenseService {

    @GET("/expenses/all")
    suspend fun getExpenses(@Query("uid") uid: Long): List<ExpenseApiModel>

}