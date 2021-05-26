package dev.sertan.android.harcamatakip.util

import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate

fun calculateCost(
    value: Double = 0.0,
    exchangeRate: ExchangeRate?,
    from: Currency?,
    to: Currency?
): Double {
    val baseCurrencyRate = exchangeRate?.data?.get(from?.code) ?: 1.0
    val targetCurrencyRate = exchangeRate?.data?.get(to?.code) ?: 1.0
    return value * targetCurrencyRate / baseCurrencyRate
}
