package com.nahuel.predictionapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.nahuel.predictionapp.R
import com.nahuel.predictionapp.databinding.ActivityPredictionDetailBinding
import com.nahuel.predictionapp.domain.model.PredictionModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PredictionDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPredictionDetailBinding
    private val predictionDetailViewModel: PredictionDetailViewModel by viewModels()

    private val arg:PredictionDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPredictionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        predictionDetailViewModel.getHoroscope(arg.type)
    }

    private fun initUI() {
        initListener()
        initUIState()
    }

    private fun initListener() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                predictionDetailViewModel.state.collect{
                    when(it){
                        PredictionDetailState.Loading -> loadinState()
                        is PredictionDetailState.Error -> errorState()
                        is PredictionDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: PredictionDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvDetail.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when(state.predictionModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_aquarius
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun loadinState() {
        binding.pb.isVisible = true
    }
}


