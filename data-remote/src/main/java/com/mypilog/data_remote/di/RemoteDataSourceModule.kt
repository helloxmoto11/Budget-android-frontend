package com.mypilog.data_remote.di

import com.mypilog.data_remote.datasource.RemoteExpenseDataSourceImpl
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindExpenseDataSource(remoteExpenseDataSource: RemoteExpenseDataSourceImpl): RemoteExpenseDataSource
}