package dev.sertan.android.harcamatakip.view.binding

import androidx.databinding.InverseMethod

object Converters {
    @JvmStatic
    @InverseMethod("doubleToString")
    fun stringToDouble(value: String?): Double = value?.toDoubleOrNull() ?: 0.0

    @JvmStatic
    fun doubleToString(value: Double?): String =
        if (value == 0.0 || value == null) ""
        else value.toString()
}