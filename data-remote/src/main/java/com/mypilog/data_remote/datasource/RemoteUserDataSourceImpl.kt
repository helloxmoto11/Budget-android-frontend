package com.mypilog.data_remote.datasource

import android.util.Log
import com.mypilog.data_remote.network.user.UserApiModel
import com.mypilog.data_remote.network.user.UserService
import com.mypilog.domain.entity.User
import com.mypilog.repository.datasource.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteUserDataSourceImpl
 @Inject constructor(
     private val userService: UserService
): RemoteUserDataSource {


    override fun getUser(uid: Long): Flow<User> = flow {
        emit(userService.getUser(56L))
    }.map {
        convert(it)
    }.catch {
        Log.d("DataSource", "getUser: ${it.stackTrace}")
    }

    private fun convert(userApiModel: UserApiModel): User {
       return User(
            uid = userApiModel.uid,
            email = userApiModel.email,
            firstName = userApiModel.firstName,
            lastName = userApiModel.lastName
        )
    }
}