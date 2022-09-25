package com.mypilog.domain.usecase.income

import com.mypilog.domain.entity.Income
import com.mypilog.domain.repository.IncomeRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllIncomeUseCase(
    configuration: Configuration,
    private val incomeRepository: IncomeRepository
): UseCase<GetAllIncomeUseCase.Request, GetAllIncomeUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> {
        return incomeRepository.getAllIncome()
            .map {
                Response(it)
            }
    }
    object Request : UseCase.Request
    data class Response(val incomeList: List<Income>): UseCase.Response
}