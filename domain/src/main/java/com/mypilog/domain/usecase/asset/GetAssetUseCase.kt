package com.mypilog.domain.usecase.asset

import com.mypilog.domain.entity.Asset
import com.mypilog.domain.repository.AssetRepository
import com.mypilog.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAssetUseCase(
    configuration: Configuration,
    private val assetRepository: AssetRepository
): UseCase<GetAssetUseCase.Request, GetAssetUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> {
        return assetRepository.getAssets()
            .map {
                Response(it)
            }
    }
    object Request : UseCase.Request
    data class Response(val assets: List<Asset>): UseCase.Response
}