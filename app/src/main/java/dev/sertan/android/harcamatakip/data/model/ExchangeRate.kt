package dev.sertan.android.harcamatakip.data.model

data class ExchangeRate(
    val base: String = LIRA,
    val rates: Map<String, Float> = mapOf()
) {
    companion object {
        const val EURO = "EUR"
        const val POUND = "GBP"
        const val DOLLAR = "USD"
        const val LIRA = "TRY"
    }
}