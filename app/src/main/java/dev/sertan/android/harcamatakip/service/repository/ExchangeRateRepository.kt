package dev.sertan.android.harcamatakip.service.repository

import dev.sertan.android.harcamatakip.service.api.ExchangeRateApi
import dev.sertan.android.harcamatakip.service.sharedpreferences.ExchangeRateSharedPref
import javax.inject.Inject

class ExchangeRateRepository @Inject
constructor(
    private val api: ExchangeRateApi,
    private val sharedPref: ExchangeRateSharedPref
) {

    val exchangeRates = sharedPref.data

    suspend fun getExchangeRates(): Boolean = try {
        val exchangeRates = api.get().body()

        exchangeRates?.let {
            sharedPref.putData(it)
        }

        exchangeRates != null
    } catch (e: Exception) {
        false
    }
}