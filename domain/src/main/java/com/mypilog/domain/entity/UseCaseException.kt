package com.mypilog.domain.entity

sealed class UseCaseException(cause: Throwable): Throwable(cause) {
    class ExpenseException(cause: Throwable): UseCaseException(cause)
    class IncomeException(cause: Throwable): UseCaseException(cause)
    class AssetException(cause: Throwable): UseCaseException(cause)
    class LiabilityException(cause: Throwable): UseCaseException(cause)
    class UnknownException(cause: Throwable): UseCaseException(cause)
    class UserException(cause: Throwable): UseCaseException(cause)

    companion object {
        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}