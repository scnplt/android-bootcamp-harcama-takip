package dev.sertan.android.harcamatakip.util

import androidx.databinding.InverseMethod

object Converter {
    @JvmStatic
    @InverseMethod("doubleToString")
    fun stringToDouble(value: String?): Double = value?.toDoubleOrNull() ?: 0.0

    @JvmStatic
    fun doubleToString(value: Double?): String =
        if (value == 0.0 || value == null) ""
        else value.toString()
}