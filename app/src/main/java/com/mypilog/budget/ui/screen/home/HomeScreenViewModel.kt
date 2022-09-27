package com.mypilog.budget.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mypilog.budget.state.UiState
import com.mypilog.domain.usecase.budget.GetBudgetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val converter: BudgetResultConverter,
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

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ViewModelCleared")
    }
}