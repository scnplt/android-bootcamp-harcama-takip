package dev.sertan.android.harcamatakip.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeRate(
    @Json(name = "rates")
    val data: Map<String, Double> = mapOf()
)
