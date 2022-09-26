package com.mypilog.domain.usecase.budget

import com.mypilog.domain.entity.Budget
import com.mypilog.domain.repository.AssetRepository
import com.mypilog.domain.repository.ExpenseRepository
import com.mypilog.domain.repository.IncomeRepository
import com.mypilog.domain.repository.LiabilityRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class GetBudgetUseCase(
    configuration: Configuration,
    private val expenseRepository: ExpenseRepository,
    private val incomeRepository: IncomeRepository,
    private val assetRepository: AssetRepository,
    private val liabilityRepository: LiabilityRepository
) : UseCase<GetBudgetUseCase.Request, GetBudgetUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        combine(
            expenseRepository.getExpenses(),
            incomeRepository.getAllIncome(),
            assetRepository.getAssets(),
            liabilityRepository.getLiabilities()
        ) { f1, f2, f3, f4 ->
            Budget(
                f1, f2, f3, f4
            )
        }.map {
            Response(it)
        }


    object Request : UseCase.Request
    data class Response(val budget: Budget) : UseCase.Response
}