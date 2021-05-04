package dev.sertan.android.harcamatakip.service.model

data class User(
    var name: String = "",
    var gender: Gender = Gender.UNKNOWN,
    var baseCurrency: Currency = Currency.LIRA
)