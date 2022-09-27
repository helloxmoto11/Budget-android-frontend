package com.mypilog.budget.ui.screen.home

import android.util.Log
import com.mypilog.budget.state.ResultConverter
import com.mypilog.domain.entity.Asset
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.entity.Income
import com.mypilog.domain.entity.Liability
import com.mypilog.domain.usecase.budget.GetBudgetUseCase
import javax.inject.Inject

private const val TAG = "BudgetResultConverter"
class BudgetResultConverter @Inject constructor() : ResultConverter<GetBudgetUseCase.Response, BudgetModel>() {

    override fun convertSuccess(response: GetBudgetUseCase.Response): BudgetModel {
        return transformBudget(
            l1 = response.budget.expenses,
            l2 = response.budget.income,
            l3 = response.budget.assets,
            l4 = response.budget.liabilities
        )
    }

    private fun  transformBudget(
        l1: List<Expense>,
        l2: List<Income>,
        l3: List<Asset>,
        l4: List<Liability>
    ): BudgetModel {
        val expenseMap = mutableMapOf<String, List<Expense>>()
        val incomeMap = mutableMapOf<String, List<Income>>()
        val assetMap = mutableMapOf<String, List<Asset>>()
        val liabilityMap = mutableMapOf<String, List<Liability>>()

        l1.forEach { expense ->
            val list = expenseMap[expense.date]?: listOf()
            expenseMap[expense.date] = list.plus(expense)
        }
        l2.forEach { income ->
            val list = incomeMap[income.date]?: listOf()
            incomeMap[income.date] = list.plus(income)
        }
        l3.forEach { asset ->
            val list = assetMap[asset.type]?: listOf()
            assetMap[asset.type] = list.plus(asset)
        }
        l4.forEach { liability ->
            val list = liabilityMap[liability.type]?: listOf()
            liabilityMap[liability.type] = list.plus(liability)
        }

        Log.d(TAG, "transformBudget: $expenseMap")
        return BudgetModel(
            expenseMap,
            incomeMap,
            assetMap,
            liabilityMap
        )
    }
}