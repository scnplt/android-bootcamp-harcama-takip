package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.data.api.ExchangeRateService
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRateRepo @Inject constructor(
    private val sharedPref: BaseSharedPref<ExchangeRate>,
    private val service: ExchangeRateService
) {
    val exchangeRates: LiveData<ExchangeRate> get() = sharedPref.data

    init {
        CoroutineScope(Dispatchers.IO).launch { updateExchangeRates() }
    }

    suspend fun updateExchangeRates(): Boolean = try {
        val body = service.get().body()
        body?.let { sharedPref.updateData(it) } != null
    } catch (_: Exception) {
        false
    }
}
