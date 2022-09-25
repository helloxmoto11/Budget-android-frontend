package com.mypilog.budget.state

sealed class UiState<out T: Any> {
    object Loading: UiState<Nothing>()
    data class Error(val errorMessage: String): UiState<Nothing>()
    data class Success<T: Any>(val data: T): UiState<T>()
}