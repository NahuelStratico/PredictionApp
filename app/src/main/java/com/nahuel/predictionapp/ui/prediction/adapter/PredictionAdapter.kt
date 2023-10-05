package com.nahuel.predictionapp.ui.prediction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nahuel.predictionapp.R
import com.nahuel.predictionapp.domain.model.PredictionInfo

class PredictionAdapter(private var predictionList: List<PredictionInfo> = emptyList(),
    private val onItemSelected:(PredictionInfo) -> Unit ) :
    RecyclerView.Adapter<PredictionViewHolder>() {

    fun updateLst(list: List<PredictionInfo>){
        predictionList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredictionViewHolder {
        return PredictionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_prediction,parent,false)
        )
    }

    override fun getItemCount(): Int = predictionList.size

    override fun onBindViewHolder(holder: PredictionViewHolder, position: Int) {
        holder.render(predictionList[position], onItemSelected)
    }
}