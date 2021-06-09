package dev.sertan.android.harcamatakip.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    var name: String = "",
    var gender: Gender = Gender.UNKNOWN,
    var baseCurrency: Currency = Currency.LIRA
)
