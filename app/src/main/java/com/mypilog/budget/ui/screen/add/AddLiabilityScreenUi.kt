package com.mypilog.budget.ui.screen.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddLiabilityScreenUi(
    screenState: AddScreenState
) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Text(text = "LIABILITY")
    }
}