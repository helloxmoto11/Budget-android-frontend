package com.mypilog.data_remote.network.user

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @GET("/user")
    suspend fun getUser(@Query("uid") uid: Long): UserApiModel

    @POST("/user")
    suspend fun saveUser(@Body userApiModel: UserApiModel)
}