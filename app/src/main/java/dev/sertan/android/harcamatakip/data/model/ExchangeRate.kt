package dev.sertan.android.harcamatakip.data.model

import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("rates")
    val data: Map<String, Double> = mapOf()
)
