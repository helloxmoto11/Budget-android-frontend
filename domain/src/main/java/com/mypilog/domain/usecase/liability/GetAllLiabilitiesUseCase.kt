package com.mypilog.domain.usecase.liability

import com.mypilog.domain.entity.Liability
import com.mypilog.domain.repository.LiabilityRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllLiabilitiesUseCase(
    configuration: Configuration,
    private val liabilityRepository: LiabilityRepository
): UseCase<GetAllLiabilitiesUseCase.Request, GetAllLiabilitiesUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> {
        return liabilityRepository.getLiabilities()
            .map {
                Response(it)
            }
    }
    object Request : UseCase.Request
    data class Response(val liabilities: List<Liability>): UseCase.Response
}