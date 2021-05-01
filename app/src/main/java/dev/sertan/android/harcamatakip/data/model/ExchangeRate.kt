package dev.sertan.android.harcamatakip.data.model

import com.google.gson.Gson

data class ExchangeRate(
    val base: String = LIRA,
    val rates: Map<String, Float> = mapOf(
        EURO to 1f,
        POUND to 1f,
        DOLLAR to 1f
    )
) {
    companion object {
        const val EURO = "EUR"
        const val POUND = "GBP"
        const val DOLLAR = "USD"
        const val LIRA = "TRY"

        fun fromJSON(json: String): ExchangeRate = Gson().fromJson(json, ExchangeRate::class.java)
    }

    fun toJSON(): String = Gson().toJson(this)
}