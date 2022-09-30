package com.mypilog.budget.ui.screen.add

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mypilog.budget.ScreenType
import com.mypilog.budget.ui.screen.home.BudgetType
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun AddExpenseScreenUi(
    screenType: ScreenType = ScreenType.PhonePortrait,
    screenState: AddScreenState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(text = "EXPENSE")

    }
}


@Preview(
    name = "Foldable",
    device = Devices.FOLDABLE,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone-landscape",
    device = Devices.AUTOMOTIVE_1024p,
    widthDp = 2000,
    heightDp = 960,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone-portrait",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class MultiScalePreviews

@MultiScalePreviews
@Composable
fun PreviewAddExpenseScreenUi() {
    BudgetTheme {
        Surface {
            AddExpenseScreenUi(screenState = AddScreenState(BudgetType.Expenses))
        }
    }
}