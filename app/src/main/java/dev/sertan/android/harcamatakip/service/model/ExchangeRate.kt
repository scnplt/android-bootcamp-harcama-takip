package dev.sertan.android.harcamatakip.service.model

import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("rates")
    val data: Map<String, Double> = mapOf()
)