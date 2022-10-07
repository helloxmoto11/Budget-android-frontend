package com.mypilog.presentation_add.expense

import androidx.compose.ui.text.input.TextFieldValue

data class AddExpenseScreenState(
    val expense: TextFieldValue = TextFieldValue(),
    val category: TextFieldValue = TextFieldValue(),
    val cost: TextFieldValue = TextFieldValue(),
    val date: TextFieldValue = TextFieldValue()
)

