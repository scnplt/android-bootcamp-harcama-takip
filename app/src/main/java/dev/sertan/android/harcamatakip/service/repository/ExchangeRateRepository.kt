package dev.sertan.android.harcamatakip.service.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.sertan.android.harcamatakip.service.api.ExchangeRateApi
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExchangeRateRepository
@Inject constructor(@ApplicationContext context: Context, private val api: ExchangeRateApi) {
    private val valueClass = ExchangeRate::class.java

    private val key = valueClass.name

    private val defaultValue = valueClass.newInstance()

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { sp, key ->
        if (key == this.key) {
            val json = sp.getString(key, toJson(defaultValue))!!
            val data = fromJson(json)
            _exchangeRates.postValue(data)
        }
    }

    private val sharedPreferences = context
        .getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        .apply { registerOnSharedPreferenceChangeListener(listener) }

    private val _exchangeRates = MutableLiveData(getDataFromSharedPref())
    val exchangeRates: LiveData<ExchangeRate> get() = _exchangeRates

    init {
        CoroutineScope(Dispatchers.IO).launch { updateExchangeRates() }
    }

    suspend fun updateExchangeRates(): Boolean = try {
        val result = api.get().body()
        result?.let { sharedPreferences.edit().putString(key, toJson(result)).apply() }
        result != null
    } catch (e: Exception) {
        false
    }

    private fun getDataFromSharedPref(): ExchangeRate =
        fromJson(sharedPreferences.getString(key, toJson(defaultValue))!!)

    private fun toJson(data: ExchangeRate): String = Gson().toJson(data)

    private fun fromJson(json: String): ExchangeRate = Gson().fromJson(json, valueClass)
}