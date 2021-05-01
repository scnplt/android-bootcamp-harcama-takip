package dev.sertan.android.harcamatakip.data.model

data class User(
    val name: String = "",
    val gender: Gender = Gender.UNKNOWN,
    val mainCurrency: Currency = Currency.LIRA
)