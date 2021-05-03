package dev.sertan.android.harcamatakip.service.model

data class ExchangeRate(
    val base: String = Currency.LIRA.code,
    val rates: Map<String, Double> = mapOf(
        Currency.EURO.code to 1.0,
        Currency.POUND.code to 1.0,
        Currency.DOLLAR.code to 1.0
    )
)