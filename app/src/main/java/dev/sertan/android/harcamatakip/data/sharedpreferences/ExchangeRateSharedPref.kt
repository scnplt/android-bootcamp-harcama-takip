package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.sertan.android.harcamatakip.data.model.ExchangeRate

class ExchangeRateSharedPref(context: Context) {
    private val key = "${context.packageName}.${this::class.simpleName}"

    private val sharedPref: SharedPreferences = context
        .getSharedPreferences(key, Context.MODE_PRIVATE)

    private val _exchangeRates = MutableLiveData<ExchangeRate>()
    val exchangeRates: LiveData<ExchangeRate>
        get() = _exchangeRates

    init {
        setupListener()
        getExchangeRates()
    }

    fun putExchangeRates(value: ExchangeRate) =
        sharedPref.edit()
            .clear()
            .putString(key, value.toJSON())
            .apply()

    private fun setupListener() {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, _ ->
            getExchangeRates()
        }
        sharedPref.registerOnSharedPreferenceChangeListener(listener)
    }

    private fun getExchangeRates() {
        val default = ExchangeRate().toJSON()
        val json = sharedPref.getString(key, default)
        _exchangeRates.postValue(ExchangeRate.fromJSON(json!!))
    }
}