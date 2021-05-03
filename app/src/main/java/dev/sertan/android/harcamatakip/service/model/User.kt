package dev.sertan.android.harcamatakip.service.model

data class User(
    val name: String = "",
    val gender: Gender = Gender.UNKNOWN,
    var mainCurrency: Currency = Currency.LIRA
)