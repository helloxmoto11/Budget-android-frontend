package com.mypilog.budget.di

import com.mypilog.domain.repository.AssetRepository
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.domain.repository.IncomeRepository
import com.mypilog.domain.repository.LiabilityRepository
import com.mypilog.repository.AssetRepositoryImpl
import com.mypilog.repository.ExpenseRepositoryImpl
import com.mypilog.repository.IncomeRepositoryImpl
import com.mypilog.repository.LiabilityRepositoryImpl
import com.mypilog.repository.datasource.remote.RemoteAssetDataSource
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
import com.mypilog.repository.datasource.remote.RemoteIncomeDataSource
import com.mypilog.repository.datasource.remote.RemoteLiabilityDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideExpenseRepository(
        remoteExpenseDataSource: RemoteExpenseDataSource,
    ): ExpenseRepository = ExpenseRepositoryImpl(
        remoteExpenseDataSource
    )

    @Provides
    fun provideIncomeRepository(
        remoteIncomeDataSource: RemoteIncomeDataSource
    ): IncomeRepository = IncomeRepositoryImpl(
        remoteIncomeDataSource
    )

    @Provides
    fun provideAssetRepository(
        remoteAssetDataSource: RemoteAssetDataSource
    ): AssetRepository = AssetRepositoryImpl(
        remoteAssetDataSource
    )

    @Provides
    fun provideLiabilityRepository(
        remoteLiabilityDataSource: RemoteLiabilityDataSource
    ): LiabilityRepository = LiabilityRepositoryImpl(
        remoteLiabilityDataSource
    )
}