package com.mypilog.presentation_add.expense

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.presentation_add.BudgetDateInputTextField
import com.mypilog.presentation_add.BudgetTextField
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.ScreenType

@Composable
fun AddExpenseScreen(
    viewModel: AddExpenseScreenViewModel = hiltViewModel(),
    screenType: ScreenType
) {
    AddExpenseScreenUi(
        screenState = viewModel.screenState,
        onUpdateScreenState = viewModel::onUpdateScreenState,
        screenType
    )
}

@Composable
fun AddExpenseScreenUi(
    screenState: AddExpenseScreenState = AddExpenseScreenState(),
    onUpdateScreenState: (AddExpenseScreenState) -> Unit,
    screenType: ScreenType
) {


    Text(text = "Add Expense")

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
            placeholder = "Expense"
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