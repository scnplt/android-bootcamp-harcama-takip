package dev.sertan.android.harcamatakip.view.binding

import androidx.databinding.InverseMethod

object BindingConverter {
    @InverseMethod("doubleToString")
    fun stringToDouble(value: String): Double = value.toDoubleOrNull() ?: 0.0

    fun doubleToString(value: Double): String = if (value == 0.0) "" else value.toString()
}