package com.mypilog.presentation_add.expense

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mypilog.domain.entity.Expense
import com.mypilog.domain.usecase.expense.AddExpenseUseCase
import com.mypilog.presentation_common.state.UiState
import com.mypilog.presentation_common.util.convertDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddExpenseScreenViewModel @Inject constructor(
    private val useCase: AddExpenseUseCase,
    private val converter: ExpenseResultConverter
) : ViewModel() {

    companion object {
        private const val TAG = "AddExpenseScreenViewMod"
    }

    var screenState by mutableStateOf(AddExpenseScreenState())
        private set


    fun onUpdateScreenState(state: AddExpenseScreenState) {
        screenState = state
    }

    fun onAddExpense() {
        // TODO:  need a text field validator.

        val expense = Expense(
            name = screenState.expense.text,
            category = screenState.category.text,
            cost = screenState.cost.text.toDouble(),
            uid = 55L,
            date = convertDate(screenState.date.text),
            timeStamp = LocalDateTime.now().toString()
        )

        viewModelScope.launch {
            useCase.invoke(AddExpenseUseCase.Request(expense))
                .map {
                    converter.convert(it)
                }.collect {
                    when (it) {
                        is UiState.Error -> {
                            // TODO: show snackbar
                            Log.d(TAG, "onAddExpense: Error: ${it.errorMessage}")
                        }
                        is UiState.Loading -> {
                            // TODO: show loading icon.
                            Log.d(TAG, "onAddExpense: loading")
                        }
                        is UiState.Success -> {
                            // TODO: pop backstack and show success SnackBar.
                            Log.d(TAG, "onAddExpense: Success: ${it.data}")
                        }
                    }
                }
        }
    }
}