package com.mypilog.budget.di

import com.mypilog.domain.repository.AssetRepository
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.domain.repository.IncomeRepository
import com.mypilog.domain.repository.LiabilityRepository
import com.mypilog.domain.usecase.UseCase
import com.mypilog.domain.usecase.budget.GetBudgetUseCase
import com.mypilog.domain.usecase.expense.GetExpensesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetExpensesUseCase(
        configuration: UseCase.Configuration,
        expenseRepository: ExpenseRepository,
    ): GetExpensesUseCase = GetExpensesUseCase(
        configuration = configuration,
        expenseRepository = expenseRepository
    )

    @Provides
    fun providesGetBudgetUseCase(
        configuration: UseCase.Configuration,
        expenseRepository: ExpenseRepository,
        incomeRepository: IncomeRepository,
        assetRepository: AssetRepository,
        liabilityRepository: LiabilityRepository
    ): GetBudgetUseCase = GetBudgetUseCase(
        configuration = configuration,
        expenseRepository, incomeRepository, assetRepository, liabilityRepository
    )
}