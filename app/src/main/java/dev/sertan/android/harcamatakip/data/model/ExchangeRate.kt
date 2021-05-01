package dev.sertan.android.harcamatakip.data.model

import com.google.gson.Gson

data class ExchangeRate(
    val base: String = Currency.LIRA.code,
    val rates: Map<String, Float> = mapOf(
        Currency.EURO.code to 1f,
        Currency.POUND.code to 1f,
        Currency.DOLLAR.code to 1f
    )
) {
    fun toJSON(): String = Gson().toJson(this)

    companion object {
        fun fromJSON(json: String): ExchangeRate = Gson().fromJson(json, ExchangeRate::class.java)
    }
}