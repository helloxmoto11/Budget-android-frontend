package com.mypilog.budget.ui.screen.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mypilog.budget.ScreenType

@Composable
fun AddAssetScreenUi(
    screenType: ScreenType,
    screenState: AddScreenState) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Text(text = "ASSET")
    }
}