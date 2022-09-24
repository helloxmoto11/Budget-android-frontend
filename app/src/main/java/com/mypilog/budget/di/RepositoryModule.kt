package com.mypilog.budget.di

import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.repository.ExpenseRepositoryImpl
import com.mypilog.repository.datasource.local.LocalExpenseDataSource
import com.mypilog.repository.datasource.remote.RemoteExpenseDataSource
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
        localExpenseDataSource: LocalExpenseDataSource
    ): ExpenseRepository = ExpenseRepositoryImpl(
        remoteExpenseDataSource,
        localExpenseDataSource
    )
}