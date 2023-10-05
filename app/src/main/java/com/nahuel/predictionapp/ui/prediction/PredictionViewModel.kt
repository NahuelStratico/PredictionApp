package com.nahuel.predictionapp.ui.prediction

import androidx.lifecycle.ViewModel
import com.nahuel.predictionapp.data.provider.PredictionProvider
import com.nahuel.predictionapp.domain.model.PredictionInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PredictionViewModel @Inject constructor(predictionProvider: PredictionProvider) : ViewModel(){

    private var _prediction = MutableStateFlow<List<PredictionInfo>>(emptyList())
    val prediction:StateFlow<List<PredictionInfo>> = _prediction

    init {
        _prediction.value = predictionProvider.getPredictions()
    }

}