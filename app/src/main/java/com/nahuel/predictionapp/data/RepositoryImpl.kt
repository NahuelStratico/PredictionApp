package com.nahuel.predictionapp.data

import android.util.Log
import com.nahuel.predictionapp.data.network.PredictionApiService
import com.nahuel.predictionapp.domain.Repository
import com.nahuel.predictionapp.domain.model.HoroscopeModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: PredictionApiService):Repository {
    override suspend fun getPrediction(sign: String): HoroscopeModel? {
        kotlin.runCatching { apiService.getPrediction(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Nahuel", "Ha ocurrido un error ${it.message}") }

        return null
    }
}