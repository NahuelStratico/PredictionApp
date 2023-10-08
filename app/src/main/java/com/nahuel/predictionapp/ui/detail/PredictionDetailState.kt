package com.nahuel.predictionapp.ui.detail

import com.nahuel.predictionapp.domain.model.PredictionModel

sealed class PredictionDetailState {
    data object Loading: PredictionDetailState()
    data class Error(val error: String): PredictionDetailState()
    data class Success(val prediction: String, val sign:String, val predictionModel: PredictionModel): PredictionDetailState()
}