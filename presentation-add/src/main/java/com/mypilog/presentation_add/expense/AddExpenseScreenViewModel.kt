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
): ViewModel() {

    companion object {
        private const val TAG = "AddExpenseScreenViewMod"
    }


    var screenState by mutableStateOf(AddExpenseScreenState())
    private set


    fun onUpdateScreenState(state: AddExpenseScreenState) {
        screenState = state
    }

    fun onAddExpense() {
        val date = screenState.date.text.split("-")
        val year = date[2]
        val month = if (date[0].length < 2) "0${date[0]}" else date[0]
        val day = if (date[1].length < 2) "0${date[1]}" else date[1]
        val formattedDate = "$year-$month-$day"

        val expense = Expense(
            name = screenState.expense.text,
            category = screenState.category.text,
            cost = screenState.cost.text.toDouble(),
            uid = 55L,
            date = formattedDate,
            timeStamp = LocalDateTime.now().toString()
        )

        viewModelScope.launch {
            useCase.invoke(AddExpenseUseCase.Request(expense))
                .map {
                    converter.convert(it)
                }.collect{
                    when (it){
                        is UiState.Error -> {
                            Log.d(TAG, "onAddExpense: Error: ${it.errorMessage}")}
                        is UiState.Loading -> {
                            Log.d(TAG, "onAddExpense: loading")}
                        is UiState.Success -> {
                            Log.d(TAG, "onAddExpense: Success: ${it.data}")}
                    }
                }
        }
    }


}