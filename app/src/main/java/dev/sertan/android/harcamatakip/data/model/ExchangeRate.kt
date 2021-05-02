package dev.sertan.android.harcamatakip.data.model

data class ExchangeRate(
    val base: String = Currency.LIRA.code,
    val rates: Map<String, Float> = mapOf(
        Currency.EURO.code to 1f,
        Currency.POUND.code to 1f,
        Currency.DOLLAR.code to 1f
    )
)