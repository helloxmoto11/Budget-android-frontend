package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mypilog.budget.state.UiState

@Composable
fun <T: Any> CommonScreen(uiState: UiState<T>,  onError: (String) -> Unit,onSuccess: @Composable (T) -> Unit) {

    when (uiState) {
        is UiState.Error -> onError(uiState.errorMessage)
        UiState.Loading -> Loading()
        is UiState.Success -> onSuccess(uiState.data)
    }
}


@Composable
fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator()
    }
}