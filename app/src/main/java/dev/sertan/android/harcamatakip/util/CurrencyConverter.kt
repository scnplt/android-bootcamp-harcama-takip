package dev.sertan.android.harcamatakip.util

import dev.sertan.android.harcamatakip.service.model.Currency

object CurrencyConverter {
    fun convert(
        value: Double,
        exchangeRates: Map<String, Double>,
        to: Currency = Currency.LIRA,
        from: Currency = Currency.LIRA
    ): Double {
        val baseCurrencyRate = exchangeRates[from.code] ?: 1.0
        val targetCurrencyRate = exchangeRates[to.code] ?: 1.0
        return value * targetCurrencyRate / baseCurrencyRate
    }
}