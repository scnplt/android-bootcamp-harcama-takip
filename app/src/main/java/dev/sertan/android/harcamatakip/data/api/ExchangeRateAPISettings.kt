package dev.sertan.android.harcamatakip.data.api

import dev.sertan.android.harcamatakip.data.model.ExchangeRate

object ExchangeRateAPISettings {
    const val BASE_URL = "https://api.exchangerate.host/"
    const val ENDPOINT = "latest"
    const val CURRENCIES = "${ExchangeRate.EURO}, ${ExchangeRate.POUND}, ${ExchangeRate.DOLLAR}"
    const val BASE_CURRENCY = ExchangeRate.LIRA
}