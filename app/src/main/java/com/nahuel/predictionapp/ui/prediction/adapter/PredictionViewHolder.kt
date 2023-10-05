package com.nahuel.predictionapp.ui.prediction.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.nahuel.predictionapp.databinding.ItemPredictionBinding
import com.nahuel.predictionapp.domain.model.PredictionInfo

class PredictionViewHolder( view: View) : RecyclerView.ViewHolder(view)  {

    private val binding = ItemPredictionBinding.bind(view)

    fun render(predictionInfo: PredictionInfo, onItemSelected: (PredictionInfo) -> Unit){

        binding.ivPrediction.setImageResource(predictionInfo.image)
        binding.tvTitle.text = binding.tvTitle.context.getString(predictionInfo.name)

        binding.itemPredictionContainer.setOnClickListener {
            startRotation(binding.ivPrediction, newItemSelected = { onItemSelected( predictionInfo ) })
            //onItemSelected( predictionInfo )
        }
    }

    private fun startRotation(view: View, newItemSelected:() -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newItemSelected() }
            start()
        }
    }
}