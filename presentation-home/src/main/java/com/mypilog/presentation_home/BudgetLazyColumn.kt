package com.mypilog.presentation_home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mypilog.domain.entity.*
import com.mypilog.presentation_common.BudgetType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpenseLazyColumn(
    modifier: Modifier = Modifier,
    expenses: Map<String, List<Expense>>,
    type: BudgetType
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 56.dp, end = 8.dp)
    ) {

        item {
            PieChart(
                tempText = type.name,
                modifier = Modifier
            )
        }
        stickyHeader {

        }


        expenses.forEach { (date, expenses) ->
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Text(text = date)
                }
            }
            items(expenses) {
                BudgetItem(name = it.name, amount = it.cost.toString())
                Spacer(modifier = Modifier.height(4.dp))
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IncomeLazyColumn(
    modifier: Modifier = Modifier,
    income: Map<String, List<Income>>,
    type: BudgetType
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 56.dp, end = 8.dp)
    ) {

        item {
            PieChart(
                tempText = type.name,
                modifier = Modifier
            )
        }

        income.forEach { (date, incomeList) ->
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Text(text = date)
                }
            }

            items(incomeList) {
                BudgetItem(name = it.name, amount = it.amount.toString())
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AssetLazyColumn(
    modifier: Modifier = Modifier,
    assets: Map<String, List<Asset>>,
    type: BudgetType
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 56.dp, end = 8.dp)
    ) {

        item {
            PieChart(
                tempText = type.name,
                modifier = Modifier
            )
        }

        assets.forEach { (type, assets) ->
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Text(text = type)
                }
            }

            items(assets) {
                BudgetItem(name = it.name, amount = it.value.toString())
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiabilitiesLazyColumn(
    modifier: Modifier = Modifier,
    liabilities: Map<String, List<Liability>>,
    type: BudgetType
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 56.dp, end = 8.dp)
    ) {

        item {
            PieChart(
                tempText = type.name,
                modifier = Modifier
            )
        }


        liabilities.forEach { (type, liabilityList) ->
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Text(text = type)
                }
            }

            items(liabilityList) {
                BudgetItem(name = it.name, amount = it.balance.toString())
                Spacer(modifier = Modifier.height(4.dp))
            }
        }

    }
}