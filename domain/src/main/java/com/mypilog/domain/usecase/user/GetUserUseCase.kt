package com.mypilog.domain.usecase.user

import com.mypilog.domain.entity.User
import com.mypilog.domain.repository.UserRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetUserUseCase(
    configuration: Configuration,
    private val userRepository: UserRepository
): UseCase<GetUserUseCase.Request, GetUserUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        return userRepository.getUser(request.uid)
            .map {
                Response(it)
            }
    }
    data class Request(val uid: Long): UseCase.Request
    data class Response(val user: User): UseCase.Response
}