package com.mypilog.presentation_add

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.Surface
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.ScreenType

@Composable
fun AddScreen(
    screenType: ScreenType,

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
    screenType: ScreenType = ScreenType.PhonePortrait,
    type: BudgetType = BudgetType.Expenses,
    screenState: AddScreenState = AddScreenState(type)
) {

    when (type) {
        BudgetType.Assets -> AddAssetScreenUi(screenType = screenType, screenState = screenState)
        BudgetType.Expenses -> AddExpenseScreenUi(screenState = screenState)
        BudgetType.Income -> AddIncomeScreenUi(screenState = screenState)
        BudgetType.Liabilities -> AddLiabilityScreenUi(screenState = screenState)
    }

}

@Preview
@Composable
fun PreviewAddScreen() {
        Surface {
            AddScreenUi()
        }
}