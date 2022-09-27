package com.mypilog.repository.datasource.remote

import com.mypilog.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface RemoteUserDataSource {

    fun getUser(uid: Long): Flow<User>

    suspend fun saveUser(user: User)
}