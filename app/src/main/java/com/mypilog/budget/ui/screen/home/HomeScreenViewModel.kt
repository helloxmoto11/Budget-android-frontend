package com.mypilog.budget.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mypilog.budget.state.UiState
import com.mypilog.domain.usecase.budget.GetBudgetUseCase
import com.mypilog.domain.usecase.expense.GetExpensesUseCase
import com.mypilog.domain.usecase.income.GetAllIncomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val converter: ExpenseResultConverter,
    private val getBudgetUseCase: GetBudgetUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "HomeScreenViewModel"
    }

    var homeScreenState by mutableStateOf(HomeScreenState(uiState = UiState.Loading))
        private set


    init {
        Log.d(TAG, "test: init")
        viewModelScope.launch {
            Log.d(TAG, "test: Launch")


            getBudgetUseCase.invoke(GetBudgetUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    homeScreenState = when (it) {
                        //show loading progress
                        is UiState.Loading -> {
                            homeScreenState.copy(uiState = it)
                        }
                        is UiState.Error -> {
                            //show snackbar when error thrown
                            Log.d(TAG, "UiStateError: ${it.errorMessage}")
                            homeScreenState.copy(uiState = it)
                        }
                        is UiState.Success -> {
                            Log.d(TAG, "success: ${it.data.expenses}")
                            homeScreenState.copy(uiState = it)
                        }
                    }
                }

        }
    }

}