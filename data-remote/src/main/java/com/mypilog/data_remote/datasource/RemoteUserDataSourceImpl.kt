package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.User
import com.mypilog.repository.datasource.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteUserDataSourceImpl @Inject constructor(

): RemoteUserDataSource {
    override fun getUser(uid: Long): Flow<User> {
        TODO("Not yet implemented")
    }
}