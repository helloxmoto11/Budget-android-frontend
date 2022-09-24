package com.mypilog.budget.ui.screen.home

import androidx.lifecycle.ViewModel
import com.mypilog.domain.usecase.expense.GetExpensesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getExpensesUseCase: GetExpensesUseCase
): ViewModel() {


}