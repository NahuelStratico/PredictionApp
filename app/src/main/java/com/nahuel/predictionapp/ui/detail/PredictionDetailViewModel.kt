package com.nahuel.predictionapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahuel.predictionapp.domain.model.PredictionModel
import com.nahuel.predictionapp.domain.useCase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PredictionDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) : ViewModel() {

    private var _state = MutableStateFlow<PredictionDetailState>(PredictionDetailState.Loading)
    val state: StateFlow<PredictionDetailState> = _state

    private lateinit var horoscope: PredictionModel
    fun getHoroscope(sign: PredictionModel){
        viewModelScope.launch {
            horoscope = sign
            _state.value = PredictionDetailState.Loading
            val result = withContext(Dispatchers.IO){ getPredictionUseCase(sign.name)}
            if (result!=null){
                _state.value = PredictionDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = PredictionDetailState.Error("Ha ocurrido un error, intentelo nuevamente")
            }
        }

    }

}