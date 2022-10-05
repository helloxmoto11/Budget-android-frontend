package com.mypilog.budget.ui.screen.add

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mypilog.budget.ScreenType
import com.mypilog.budget.ui.screen.home.BudgetType
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun AddExpenseScreenUi(
    screenType: ScreenType = ScreenType.PhonePortrait, screenState: AddScreenState
) {

    val modifier = if (screenType is ScreenType.PhonePortrait) {
        Modifier.fillMaxWidth()
    } else Modifier.width(480.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        BudgetDateInputTextField(
            modifier = modifier,
            textFieldValue = TextFieldValue(),
            onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))

        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = TextFieldValue(),
            onValueChange = {},
            placeholder = "Name"
        )
        Spacer(modifier = Modifier.height(16.dp))



        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = TextFieldValue(),
            onValueChange = {},
            placeholder = "Category"
        )
        Spacer(modifier = Modifier.height(16.dp))


        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = TextFieldValue(),
            onValueChange = {},
            placeholder = "Cost"
        )
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { /*TODO*/ }, modifier = modifier
        ) {
            Text(text = "Add")
        }

    }
}


@Preview(
    name = "Foldable", device = Devices.FOLDABLE, uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone-landscape",
    device = Devices.AUTOMOTIVE_1024p,
    widthDp = 2000,
    heightDp = 960,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone-portrait", uiMode = UI_MODE_NIGHT_YES
)
annotation class MultiScalePreviews

@MultiScalePreviews
@Composable
fun PreviewAddExpenseScreenUi() {
    BudgetTheme {
        Surface {
            AddExpenseScreenUi(
                screenType = ScreenType.Foldable, screenState = AddScreenState(BudgetType.Expenses)
            )
        }
    }
}