package com.nahuel.predictionapp.ui.prediction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nahuel.predictionapp.databinding.FragmentPredictionBinding
import com.nahuel.predictionapp.domain.model.PredictionInfo
import com.nahuel.predictionapp.domain.model.PredictionInfo.*
import com.nahuel.predictionapp.domain.model.PredictionModel
import com.nahuel.predictionapp.ui.prediction.adapter.PredictionAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PredictionFragment : Fragment() {

    private val predictionVideModel by viewModels<PredictionViewModel>()
    private lateinit var predictionAdapter: PredictionAdapter

    private var _binding: FragmentPredictionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initAdapter()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                predictionVideModel.prediction.collect {
                    // changes in prediction
                        predictionAdapter.updateLst(it)
                }
            }
        }
    }

    private fun initAdapter() {
        predictionAdapter = PredictionAdapter( onItemSelected = {
           val type = when(it){
                Aquarius -> PredictionModel.Aquarius
                Aries -> PredictionModel.Aries
                Cancer -> PredictionModel.Cancer
                Capricorn -> PredictionModel.Capricorn
                Geminis -> PredictionModel.Gemini
                Leo -> PredictionModel.Leo
                Libra -> PredictionModel.Libra
                Pisces -> PredictionModel.Pisces
                Sagittarius -> PredictionModel.Sagittarius
                Scorpio -> PredictionModel.Scorpio
                Taurus -> PredictionModel.Taurus
                Virgo -> PredictionModel.Virgo
            }
            findNavController().navigate(
                PredictionFragmentDirections.actionPredictionFragmentToPredictionDetailActivity(type)
            )
        } )
        binding.rvPrediction.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = predictionAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPredictionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}