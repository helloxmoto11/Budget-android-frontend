package com.mypilog.budget.state

import android.util.Log
import com.mypilog.domain.entity.Result

abstract class ResultConverter<T: Any, R: Any> {

    init {
        Log.d("convert", "abstract converter: created")
    }

    fun convert(result: Result<T>): UiState<R> {
        Log.d("convert", "convert called")

        return when (result) {
            is Result.Error -> {
                UiState.Error(result.exception.localizedMessage.orEmpty())
            }
            is Result.Success -> {
                UiState.Success(convertSuccess(result.data))
            }
        }
    }

    abstract fun convertSuccess(data: T): R
}