package com.mypilog.domain.repository

import com.mypilog.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(uid: Long): Flow<User>
}