package com.mypilog.budget.state

import com.mypilog.domain.entity.Result
import java.net.SocketTimeoutException

private const val TAG = "ResultConverter"
abstract class ResultConverter<T: Any, R: Any> {

    fun convert(result: Result<T>): UiState<R> {
        return when (result) {
            is Result.Error -> {
                val errorMessage = if (result.exception.cause is SocketTimeoutException) {
                    "Connection Timed Out"
                } else {
                    result.exception.localizedMessage.orEmpty() + result.exception.javaClass.simpleName
                }
                UiState.Error(errorMessage)
            }
            is Result.Success -> {
                UiState.Success(convertSuccess(result.data))
            }
        }
    }

    abstract fun convertSuccess(response: T): R
}