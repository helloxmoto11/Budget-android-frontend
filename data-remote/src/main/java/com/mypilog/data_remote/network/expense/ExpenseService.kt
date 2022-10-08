package com.mypilog.data_remote.network.expense

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ExpenseService {

    @GET("/expenses/all")
    suspend fun getAllExpenses(@Query("uid") uid: Long): List<ExpenseApiModel>

    @POST("/expenses")
    suspend fun saveExpense(@Body expenseApiModel: ExpenseApiModel): ExpenseApiModel

}