package com.mypilog.budget.ui.screen.add

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.budget.ui.screen.home.BudgetType
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun AddScreen(
    addScreenViewModel: AddScreenViewModel = hiltViewModel(),
    type: BudgetType
) {
    val screenState = AddScreenState(BudgetType.Expenses)

    AddScreenUi(
        type = type,
        screenState = screenState
    )

}

@Composable
fun AddScreenUi(
    type: BudgetType = BudgetType.Expenses,
    screenState: AddScreenState = AddScreenState(type)
) {

    when (type) {
        BudgetType.Assets -> AddAssetScreenUi(screenState = screenState)
        BudgetType.Expenses -> AddExpenseScreenUi(screenState = screenState)
        BudgetType.Income -> AddIncomeScreenUi(screenState = screenState)
        BudgetType.Liabilities -> AddLiabilityScreenUi(screenState = screenState)
    }

}

@Preview
@Composable
fun PreviewAddScreen() {
    BudgetTheme {
        Surface {
            AddScreenUi()
        }
    }
}