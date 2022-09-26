package com.mypilog.budget.ui.screen.home

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpenseLazyColumn(
    modifier: Modifier = Modifier,
    expenses: List<Expense>,
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-25-2022")
            }
        }

        items(expenses) {
            BudgetItem(name = it.name, amount = it.cost.toString())
            Spacer(modifier = Modifier.height(4.dp))
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-26-2022")
            }
        }
        items(15) {
            BudgetItem()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IncomeLazyColumn(
    modifier: Modifier = Modifier,
    income: List<Income>,
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-25-2022")
            }
        }

        items(income) {
            BudgetItem(name = it.name, amount = it.amount.toString())
            Spacer(modifier = Modifier.height(4.dp))
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-26-2022")
            }
        }
        items(15) {
            BudgetItem()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AssetLazyColumn(
    modifier: Modifier = Modifier,
    assets: List<Asset>,
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-25-2022")
            }
        }

        items(assets) {
            BudgetItem(name = it.name, amount = it.value.toString())
            Spacer(modifier = Modifier.height(4.dp))
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-26-2022")
            }
        }
        items(15) {
            BudgetItem()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LiabilitiesLazyColumn(
    modifier: Modifier = Modifier,
    liabilities: List<Liability>,
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-25-2022")
            }
        }

        items(liabilities) {
            BudgetItem(name = it.name, amount = it.balance.toString())
            Spacer(modifier = Modifier.height(4.dp))
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
            ) {
                Text(text = "09-26-2022")
            }
        }
        items(15) {
            BudgetItem()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}