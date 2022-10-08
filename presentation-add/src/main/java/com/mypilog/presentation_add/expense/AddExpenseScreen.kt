package com.mypilog.presentation_add.expense

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mypilog.presentation_add.BudgetDateInputTextField
import com.mypilog.presentation_add.BudgetTextField
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.ScreenType
import kotlin.math.cos

@Composable
fun AddExpenseScreen(
    viewModel: AddExpenseScreenViewModel = hiltViewModel(),
    screenType: ScreenType
) {
    AddExpenseScreenUi(
        screenState = viewModel.screenState,
        onUpdateScreenState = viewModel::onUpdateScreenState,
        screenType = screenType,
        onAddExpense = viewModel::onAddExpense
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddExpenseScreenUi(
    screenState: AddExpenseScreenState = AddExpenseScreenState(),
    screenType: ScreenType,
    onUpdateScreenState: (AddExpenseScreenState) -> Unit,
    onAddExpense: () -> Unit
) {

    val keyboard = LocalSoftwareKeyboardController.current

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
            textFieldValue = screenState.date,
            onValueChange = { onUpdateScreenState(screenState.copy(date = it)) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = screenState.expense,
            onValueChange = { onUpdateScreenState(screenState.copy(expense = it)) },
            placeholder = "Expense",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))



        BudgetTextField(
            modifier = modifier,
            type = BudgetType.Expenses,
            textFieldValue = screenState.category,
            onValueChange = { onUpdateScreenState(screenState.copy(category = it)) },
            placeholder = "Category",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
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
            textFieldValue = screenState.cost,
            onValueChange = { onUpdateScreenState(screenState.copy(cost = it)) },
            placeholder = "Cost",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AttachMoney,
                    contentDescription = "Cost"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { keyboard?.hide() })
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = onAddExpense,
            modifier = modifier
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