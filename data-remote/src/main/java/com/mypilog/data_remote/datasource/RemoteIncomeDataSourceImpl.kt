package com.mypilog.data_remote.datasource

import com.mypilog.data_remote.network.income.IncomeApiModel
import com.mypilog.data_remote.network.income.IncomeService
import com.mypilog.domain.entity.Income
import com.mypilog.domain.entity.UseCaseException
import com.mypilog.domain.entity.fakeIncome
import com.mypilog.repository.datasource.remote.RemoteIncomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteIncomeDataSourceImpl @Inject constructor(
    private val incomeService: IncomeService
) : RemoteIncomeDataSource {
    override fun getAllIncome(): Flow<List<Income>> = flow {
        emit(incomeService.getAllIncome(56L))
    }.map { incomeApiModelList ->
        incomeApiModelList
            .map {
                convert(it)
            }
    }.catch {
        throw UseCaseException.IncomeException(it)
    }

    override fun getIncome(id: Long): Flow<Income> {
        TODO("Not yet implemented")
    }

    override suspend fun saveIncome(income: Income) {
        TODO("Not yet implemented")
    }

    private fun convert(apiModel: IncomeApiModel): Income {
        return Income(
            id = apiModel.id,
            name = apiModel.name,
            type = apiModel.type,
            amount = apiModel.amount,
            uid = apiModel.uid,
            date = apiModel.date,
            timeStamp = apiModel.timeStamp
        )
    }
}