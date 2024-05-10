package com.harkhark.core.data.repository

import com.harkhark.core.domain.repository.LoveRepository
import com.harkhark.core.network.api.LoveCalculatorApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoveRepositoryImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi
): LoveRepository {
    override suspend fun calculateLove(sName: String, fName: String): Flow<String>  = flow {
        loveCalculatorApi.getPercentage(sName,fName).body().let {
            emit(it?.result ?: "Error")
        }
    }
}