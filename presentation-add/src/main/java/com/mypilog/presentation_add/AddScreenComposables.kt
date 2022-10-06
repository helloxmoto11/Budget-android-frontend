package com.mypilog.presentation_add

import android.app.DatePickerDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.mypilog.presentation_common.BudgetType

@Composable
fun BudgetTextField(
    modifier: Modifier,
    type: BudgetType,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String
) {

    when (type) {
        BudgetType.Assets -> {

        }
        BudgetType.Expenses -> {

        }
        BudgetType.Income -> {

        }
        BudgetType.Liabilities -> {

        }
    }

    TextField(
        value = textFieldValue,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text(text = placeholder) }
    )
}

@Composable
fun BudgetDateInputTextField(
    modifier: Modifier,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    val context = LocalContext.current

    val datePickerDialog = DatePickerDialog(context)

    datePickerDialog.setOnDateSetListener { datePicker, year, month, day ->
        onValueChange(TextFieldValue("$month-$day-$year"))
    }

    TextField(
        value = textFieldValue,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text("Date") },
        leadingIcon = {
            IconButton(onClick = { datePickerDialog.show() }) {
                Icon(imageVector = Icons.Filled.CalendarMonth, contentDescription = "Date")
            }
        },
        singleLine = true
    )
}