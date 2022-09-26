package com.mypilog.data_remote.datasource

import com.mypilog.domain.entity.Income
import com.mypilog.repository.datasource.remote.RemoteIncomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class RemoteIncomeDataSourceImpl @Inject constructor(

) : RemoteIncomeDataSource {
    override fun getAllIncome(): Flow<List<Income>> = flow {
        val fakeIncome = listOf(
            Income(
                id = 1,
                name = "End of month pay",
                category = "Pay",
                amount = 28000.00,
                uid = 56L,
                date = LocalDate.now()
            ),
            Income(
                id = 2,
                name = "Mid month pay",
                category = "Pay",
                amount = 5500.00,
                uid = 56L,
                date = LocalDate.now()
            )
        )
        emit(fakeIncome)
    }

    override fun getIncome(id: Long): Flow<Income> {
        TODO("Not yet implemented")
    }

    override suspend fun saveIncome(income: Income) {
        TODO("Not yet implemented")
    }
}