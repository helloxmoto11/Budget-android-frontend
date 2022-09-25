package com.mypilog.data_remote.di

import com.mypilog.data_remote.datasource.*
import com.mypilog.repository.datasource.remote.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindExpenseDataSource(remoteExpenseDataSource: RemoteExpenseDataSourceImpl): RemoteExpenseDataSource

    @Binds
    abstract fun bindIncomeDataSource(remoteIncomeDataSource: RemoteIncomeDataSourceImpl): RemoteIncomeDataSource

    @Binds
    abstract fun bindAssetDataSource(remoteAssetDataSourceImpl: RemoteAssetDataSourceImpl): RemoteAssetDataSource

    @Binds
    abstract fun bindLiabilityDataSource(remoteLiabilityDataSourceImpl: RemoteLiabilityDataSourceImpl): RemoteLiabilityDataSource

    @Binds
    abstract fun bindUserDataSource(remoteUserDataSourceImpl: RemoteUserDataSourceImpl): RemoteUserDataSource


}