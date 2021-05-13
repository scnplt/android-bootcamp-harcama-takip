package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.data.api.ExchangeRateService
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.sharedpreferences.ExchangeRateSharedPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRateRepository
@Inject constructor(
    private val sharedPref: ExchangeRateSharedPref,
    private val service: ExchangeRateService
) {
    val exchangeRates: LiveData<ExchangeRate> get() = sharedPref.exchangeRates

    init {
        CoroutineScope(Dispatchers.IO).launch { updateExchangeRates() }
    }

    suspend fun updateExchangeRates(): Boolean = try {
        val result = service.get().body()
        result?.let { sharedPref.updateExchangeRates(it) }
        result != null
    } catch (e: Exception) {
        false
    }
}