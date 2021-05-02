package dev.sertan.android.harcamatakip.data.repository

import dev.sertan.android.harcamatakip.data.api.ExchangeRateAPI
import dev.sertan.android.harcamatakip.data.sharedpreferences.ExchangeRateSharedPref
import javax.inject.Inject

class ExchangeRateRepository @Inject
constructor(
    private val api: ExchangeRateAPI,
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