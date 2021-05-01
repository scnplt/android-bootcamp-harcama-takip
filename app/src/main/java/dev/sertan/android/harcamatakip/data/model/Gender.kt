package dev.sertan.android.harcamatakip.data.model

import com.google.gson.annotations.SerializedName

enum class Gender(val code: String) {
    @SerializedName("woman")
    WOMAN("woman"),

    @SerializedName("man")
    MAN("man"),

    @SerializedName("unknown")
    UNKNOWN("unknown")
}