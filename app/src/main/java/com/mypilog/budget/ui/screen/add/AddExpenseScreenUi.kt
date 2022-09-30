package com.mypilog.budget.ui.screen.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddExpenseScreenUi(
    screenState: AddScreenState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
         Text(text = "EXPENSE")

    }
}