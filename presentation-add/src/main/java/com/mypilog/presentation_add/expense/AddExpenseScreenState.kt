package com.mypilog.presentation_add.expense

import androidx.compose.ui.text.input.TextFieldValue

data class AddExpenseScreenState(
    val expense: TextFieldValue = TextFieldValue(),
    val category: TextFieldValue = TextFieldValue(),
    val cost: Double = 0.0,
    val date: TextFieldValue = TextFieldValue()
)

