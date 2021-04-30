package dev.sertan.android.harcamatakip.data.model

import dev.sertan.android.harcamatakip.util.Currency

data class ExchangeRate(
    val base: String,
    val date: String,
    val rates: Map<String, Float>
) {
    fun convertFromLira(TRY: Float = 1f, currency: String = Currency.DOLLAR) =
        TRY * rates[currency]!!

    fun convertToLira(amount: Float = 1f, currency: String = Currency.DOLLAR) =
        amount / rates[currency]!!
}