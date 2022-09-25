package com.mypilog.budget.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mypilog.budget.state.UiState
import com.mypilog.domain.usecase.expense.GetExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val converter: ExpenseResultConverter,
    private val getExpensesUseCase: GetExpensesUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "HomeScreenViewModel"
    }

    var homeScreenState by mutableStateOf(HomeScreenState())
        private set


    init {
        Log.d(TAG, "test: init")
        viewModelScope.launch {
            Log.d(TAG, "test: Launch")
            getExpensesUseCase.invoke(GetExpensesUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    homeScreenState = when (it) {
                        is UiState.Loading -> {
                            Log.d(TAG, "loading: ")
                            homeScreenState.copy(isLoading = true)
                        }
                        is UiState.Error -> {
                            Log.d(TAG, "error: ${it.errorMessage}")
                            homeScreenState.copy(errorMsg = it.errorMessage)
                        }
                        is UiState.Success -> {
                            Log.d(TAG, "success: ")
                            homeScreenState.copy(expenses = it.data.expenses)
                        }
                    }
                }
        }
    }

}