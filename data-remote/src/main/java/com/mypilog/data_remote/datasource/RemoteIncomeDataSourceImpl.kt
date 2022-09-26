package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Income
import com.mypilog.domain.entity.fakeIncome
import com.mypilog.repository.datasource.remote.RemoteIncomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class RemoteIncomeDataSourceImpl @Inject constructor(

) : RemoteIncomeDataSource {
    override fun getAllIncome(): Flow<List<Income>> = flow {

        emit(fakeIncome)
    }

    override fun getIncome(id: Long): Flow<Income> {
        TODO("Not yet implemented")
    }

    override suspend fun saveIncome(income: Income) {
        TODO("Not yet implemented")
    }
}