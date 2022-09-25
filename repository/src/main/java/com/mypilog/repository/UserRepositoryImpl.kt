package com.mypilog.repository

import com.mypilog.domain.entity.User
import com.mypilog.domain.repository.UserRepository
import com.mypilog.repository.datasource.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource
): UserRepository {
    override fun getUser(uid: Long): Flow<User> =
        remoteUserDataSource.getUser(uid)


}