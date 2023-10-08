package com.nahuel.predictionapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.nahuel.predictionapp.domain.model.HoroscopeModel
import com.nahuel.predictionapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date:String,
    @SerializedName("horoscope") val horoscope:String,
    @SerializedName("sign") val sign: String,
){
    fun toDomain(): HoroscopeModel{
        return HoroscopeModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}