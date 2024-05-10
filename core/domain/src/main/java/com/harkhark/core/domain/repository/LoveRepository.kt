package com.harkhark.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoveRepository {
   suspend fun calculateLove(sName: String, fName: String):Flow<String>
}