package com.harkhark.core.domain.usecase

import com.harkhark.core.domain.repository.LoveRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CalcLoveUseCase @Inject constructor(
    private val loveRepository: LoveRepository
) {
    suspend operator fun invoke(sName:String, fName:String): Flow<String> {
        return loveRepository.calculateLove(sName, fName)
    }
}