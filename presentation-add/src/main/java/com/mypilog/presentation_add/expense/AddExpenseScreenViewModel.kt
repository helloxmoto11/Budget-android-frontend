package com.mypilog.presentation_add.expense

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddExpenseScreenViewModel @Inject constructor(

): ViewModel() {

    companion object {
        private const val TAG = "AddExpenseScreenViewMod"
    }


    var screenState by mutableStateOf(AddExpenseScreenState())
    private set


    fun onUpdateScreenState(state: AddExpenseScreenState) {
        screenState = state
    }


}