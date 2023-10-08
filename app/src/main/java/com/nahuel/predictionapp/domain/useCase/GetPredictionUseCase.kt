package com.nahuel.predictionapp.domain.useCase

import com.nahuel.predictionapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)
}