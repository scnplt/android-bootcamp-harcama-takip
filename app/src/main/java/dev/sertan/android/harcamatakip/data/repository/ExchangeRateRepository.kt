package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.data.api.ExchangeRateService
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRateRepository @Inject constructor(
    private val sharedPref: BaseSharedPreferences<ExchangeRate>,
    private val service: ExchangeRateService
) {
    val exchangeRates: LiveData<ExchangeRate> get() = sharedPref.data

    init {
        CoroutineScope(Dispatchers.IO).launch { updateExchangeRates() }
    }

    suspend fun updateExchangeRates(): Boolean = try {
        val result = service.get().body()
        result?.let { sharedPref.updateData(it) }
        result != null
    } catch (_: IOException) {
        false
    }
}
