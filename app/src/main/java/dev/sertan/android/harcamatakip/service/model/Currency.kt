package dev.sertan.android.harcamatakip.service.model

import com.google.gson.annotations.SerializedName

enum class Currency(val code: String) {
    @SerializedName("try")
    LIRA("TRY"),

    @SerializedName("eur")
    EURO("EUR"),

    @SerializedName("gbp")
    POUND("GBP"),

    @SerializedName("usd")
    DOLLAR("USD")
}