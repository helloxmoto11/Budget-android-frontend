package com.mypilog.budget.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.budget.state.UiState
import com.mypilog.budget.ui.screen.CommonScreen
import com.mypilog.budget.ui.theme.BudgetTheme
import com.mypilog.domain.entity.Expense

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel  = hiltViewModel(),
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenUi(
    budgetModel: BudgetModel
) {


    var tabRowIndex by remember {
        mutableStateOf(0)
    }
    val titles = listOf("Expenses", "Income", "Assets", "Liabilities")

    ScrollableTabRow(selectedTabIndex = tabRowIndex) {
        titles.forEachIndexed { index, title ->
            Tab(
                text = { Text(text = title)},
                selected = tabRowIndex == index,
                onClick = { tabRowIndex = index })
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 56.dp, end = 8.dp)
    ) {

        item {
            PieChart(
                tempText = titles[tabRowIndex],
                modifier = Modifier
            )
        }

        stickyHeader {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)) {
                Text(text = "09-25-2022")
            }
        }

        items(budgetModel.expenses) {
            BudgetItem(name = it.name, amount = it.cost.toString())
            Spacer(modifier = Modifier.height(4.dp))
        }

        stickyHeader {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)) {
                Text(text = "09-26-2022")
            }
        }


        items(15) {
            BudgetItem()
            Spacer(modifier = Modifier.height(4.dp))
        }
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
            HomeScreenUi(BudgetModel(emptyList(), emptyList(), emptyList(), emptyList()))
        }
    }
}