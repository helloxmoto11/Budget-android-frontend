package com.mypilog.budget.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.budget.ui.screen.CommonScreen
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onError: (String) -> Unit
) {

    val homeScreenState = homeScreenViewModel.homeScreenState

    CommonScreen(
        uiState = homeScreenState.uiState,
        onError = onError
    ) { budgetModel ->
        HomeScreenUi(
            budgetModel
        )
    }
}

@Composable
fun HomeScreenUi(
    budgetModel: BudgetModel
) {

    var tabRowIndex by remember {
        mutableStateOf(0)
    }
    val titles = listOf(
        BudgetType.Expenses,
        BudgetType.Income,
        BudgetType.Assets,
        BudgetType.Liabilities
    )

    var selected by remember {
        mutableStateOf<BudgetType>(BudgetType.Expenses)
    }

    ScrollableTabRow(selectedTabIndex = tabRowIndex) {
        titles.forEachIndexed { index, title ->
            Tab(
                text = { Text(text = title.name) },
                selected = tabRowIndex == index,
                onClick = {
                    tabRowIndex = index
                    selected = titles[index]
                })
        }
    }

    when (selected) {
        BudgetType.Assets -> AssetLazyColumn(assets = budgetModel.assets, type = selected)
        BudgetType.Expenses -> ExpenseLazyColumn(expenses = budgetModel.expenses, type = selected)
        BudgetType.Income -> IncomeLazyColumn(income = budgetModel.income, type = selected)
        BudgetType.Liabilities -> LiabilitiesLazyColumn(
            liabilities = budgetModel.liabilities,
            type = selected
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewHomeScreenUi() {

    BudgetTheme {
        Surface {
            HomeScreenUi(fakeBudgetModel)
        }
    }
}