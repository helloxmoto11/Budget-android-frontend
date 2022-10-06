package com.mypilog.presentation_home

import android.content.res.Configuration
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.screen.CommonScreen

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onError: (String) -> Unit,
    scrollableTabRow: Boolean
) {
    val homeScreenState = homeScreenViewModel.homeScreenState

    CommonScreen(
        uiState = homeScreenState.uiState,
        onError = onError
    ) { budgetModel ->
        HomeScreenUi(
            budgetModel = budgetModel,
            selectedTab = homeScreenState.selectedTab,
            onTabSelected = homeScreenViewModel::onTabSelected,
            tabRowScrollable = scrollableTabRow
        )
    }
}

@Composable
fun HomeScreenUi(
    budgetModel: BudgetModel,
    selectedTab: BudgetType,
    onTabSelected: (BudgetType) -> Unit,
    tabRowScrollable: Boolean = true
) {

    AppTabRow(
        scrollable = tabRowScrollable,
        selected = selectedTab,
        onSelectedChange = onTabSelected
    )

    when (selectedTab) {
        BudgetType.Assets -> AssetLazyColumn(assets = budgetModel.assets, type = selectedTab)
        BudgetType.Expenses -> ExpenseLazyColumn(
            expenses = budgetModel.expenses,
            type = selectedTab
        )
        BudgetType.Income -> IncomeLazyColumn(income = budgetModel.income, type = selectedTab)
        BudgetType.Liabilities -> LiabilitiesLazyColumn(
            liabilities = budgetModel.liabilities,
            type = selectedTab
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewHomeScreenUi() {

        Surface {
            HomeScreenUi(
                budgetModel = fakeBudgetModel,
                selectedTab = BudgetType.Expenses,
                onTabSelected = {}
            )
        }
}