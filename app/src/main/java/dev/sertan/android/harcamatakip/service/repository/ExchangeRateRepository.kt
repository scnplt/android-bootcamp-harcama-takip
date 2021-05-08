package dev.sertan.android.harcamatakip.service.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.service.api.ExchangeRateApi
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import dev.sertan.android.harcamatakip.service.sharedpreferences.ExchangeRateSharedPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRateRepository
@Inject constructor(
    private val sharedPref: ExchangeRateSharedPref,
    private val api: ExchangeRateApi
) {
    val exchangeRates: LiveData<ExchangeRate> get() = sharedPref.exchangeRates

    init {
        CoroutineScope(Dispatchers.IO).launch { updateExchangeRates() }
    }

    suspend fun updateExchangeRates(): Boolean = try {
        val result = api.get().body()
        result?.let { sharedPref.updateExchangeRates(it) }
        result != null
    } catch (e: Exception) {
        false
    }
}