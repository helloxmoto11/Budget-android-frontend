package com.mypilog.presentation_add.expense

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

        Text(
            text = "Add Expense",
            fontSize = 32.sp
        )

        BudgetDateInputTextField(
            modifier = modifier,
            textFieldValue = TextFieldValue(),
            onValueChange = {}
        )
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
            placeholder = "Category",
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "More")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))


        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = TextFieldValue(),
            onValueChange = {},
            placeholder = "Cost",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AttachMoney,
                    contentDescription = "Cost"
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { /*TODO*/ }, modifier = modifier
        ) {
            Text(text = "Add")
        }

    }
}


@Preview
@Composable
fun PreviewExpenseScreen() {
    Surface {
        AddExpenseScreen(screenType = ScreenType.PhonePortrait)
    }
}