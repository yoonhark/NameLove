package com.harkhark.core.network.api

import com.harkhark.core.network.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoveCalculatorApi {
    @GET("/getPercentage")
    suspend fun getPercentage(
        @Query("sname") sName: String,
        @Query("fname") fName: String
    ): Response<DataLoveResponse>
}