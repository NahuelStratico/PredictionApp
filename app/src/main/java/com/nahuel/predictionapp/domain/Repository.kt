package com.nahuel.predictionapp.domain

import com.nahuel.predictionapp.domain.model.HoroscopeModel

interface Repository {
    suspend fun getPrediction(sign:String): HoroscopeModel?
}