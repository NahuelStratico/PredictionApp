package com.nahuel.predictionapp.domain.model

import com.nahuel.predictionapp.R

sealed class PredictionInfo(val image:Int, val name:Int){
    data object Aries:PredictionInfo(R.drawable.aries, R.string.aries)
    data object Taurus:PredictionInfo(R.drawable.tauro,R.string.taurus)
    data object Geminis:PredictionInfo(R.drawable.geminis,R.string.gemini)
    data object Cancer:PredictionInfo(R.drawable.cancer,R.string.cancer)
    data object Leo:PredictionInfo(R.drawable.leo,R.string.leo)
    data object Virgo:PredictionInfo(R.drawable.virgo,R.string.virgo)
    data object Libra:PredictionInfo(R.drawable.libra,R.string.libra)
    data object Scorpio:PredictionInfo(R.drawable.escorpio,R.string.scorpio)
    data object Sagittarius:PredictionInfo(R.drawable.sagitario,R.string.sagittarius)
    data object Capricorn:PredictionInfo(R.drawable.capricornio,R.string.capricorn)
    data object Aquarius:PredictionInfo(R.drawable.aquario,R.string.aquarius)
    data object Pisces:PredictionInfo(R.drawable.piscis,R.string.pisces)

}
