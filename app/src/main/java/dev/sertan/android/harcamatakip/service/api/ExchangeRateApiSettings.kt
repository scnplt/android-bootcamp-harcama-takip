package dev.sertan.android.harcamatakip.service.api

import dev.sertan.android.harcamatakip.service.model.Currency

object ExchangeRateApiSettings {
    const val BASE_URL = "https://api.exchangerate.host/"
    const val ENDPOINT = "latest"
    val CURRENCIES = "${Currency.EURO.code},${Currency.POUND.code},${Currency.DOLLAR.code}"
    val BASE_CURRENCY = Currency.LIRA.code
}