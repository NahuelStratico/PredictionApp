package com.nahuel.predictionapp.data.provider

import com.nahuel.predictionapp.domain.model.PredictionInfo
import com.nahuel.predictionapp.domain.model.PredictionInfo.*
import javax.inject.Inject

class PredictionProvider @Inject constructor(){
    fun getPredictions():List<PredictionInfo>{
        return listOf(
            Aries,
            Taurus,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces

        )
    }
}