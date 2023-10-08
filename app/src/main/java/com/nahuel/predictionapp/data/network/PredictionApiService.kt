package com.nahuel.predictionapp.data.network

import com.nahuel.predictionapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PredictionApiService {
    @GET("/{sign}")
    suspend fun getPrediction(@Path("sign") sign:String): PredictionResponse
}