package com.nahuel.predictionapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nahuel.predictionapp.R
import com.nahuel.predictionapp.databinding.FragmentPalmistryBinding
import com.nahuel.predictionapp.databinding.FragmentPredictionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}