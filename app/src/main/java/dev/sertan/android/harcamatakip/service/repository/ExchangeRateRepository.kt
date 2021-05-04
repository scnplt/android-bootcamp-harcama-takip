package dev.sertan.android.harcamatakip.service.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.service.api.ExchangeRateApi
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import dev.sertan.android.harcamatakip.service.sharedpreferences.ExchangeRateSharedPref
import javax.inject.Inject

class ExchangeRateRepository @Inject constructor(
    private val api: ExchangeRateApi,
    private val sharedPref: ExchangeRateSharedPref
) {
    val exchangeRates: LiveData<ExchangeRate>
        get() = sharedPref.data

    suspend fun getExchangeRates(): Boolean = try {
        val result = api.get().body()

        result?.let {
            sharedPref.putData(it)
        }

        result != null
    } catch (e: Exception) {
        false
    }
}