package dev.sertan.android.harcamatakip.data.api

import dev.sertan.android.harcamatakip.data.model.Currency

object ExchangeRateAPISettings {
    const val BASE_URL = "https://api.exchangerate.host/"
    const val ENDPOINT = "latest"
    val CURRENCIES = "${Currency.EURO.code},${Currency.POUND.code},${Currency.DOLLAR.code}"
    val BASE_CURRENCY = Currency.LIRA.code
}