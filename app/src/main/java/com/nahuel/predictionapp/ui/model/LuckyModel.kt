package com.nahuel.predictionapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel(
    @DrawableRes val image:Int,
    @StringRes val textLucky: Int
)
