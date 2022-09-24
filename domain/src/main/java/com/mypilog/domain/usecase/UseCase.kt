package com.mypilog.domain.usecase

import com.mypilog.domain.entity.Result
import com.mypilog.domain.entity.UseCaseException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

abstract class UseCase<I: Any, O: Any>(
    private val configuration: Configuration
) {

    fun invoke(request: I): Flow<Result<O>> = process(request)
        .map {
            Result.Success(it) as com.mypilog.domain.entity.Result<O>
        }
        .flowOn(configuration.dispatcher)
        .catch {
            emit(Result.Error(UseCaseException.createFromThrowable(it)))
        }

    internal abstract fun process(request: I): Flow<O>

    class Configuration(val dispatcher: CoroutineDispatcher)

    interface Request
    interface Response
}