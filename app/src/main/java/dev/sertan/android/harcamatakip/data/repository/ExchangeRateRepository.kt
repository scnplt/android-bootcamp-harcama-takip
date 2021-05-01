package dev.sertan.android.harcamatakip.data.repository

import dev.sertan.android.harcamatakip.data.sharedpreferences.ExchangeRateSharedPref
import dev.sertan.android.harcamatakip.data.api.ExchangeRateAPI
import javax.inject.Inject

class ExchangeRateRepository @Inject
constructor(
    private val api: ExchangeRateAPI,
    private val sharedPref: ExchangeRateSharedPref
) {

    val exchangeRates = sharedPref.exchangeRates

    suspend fun getExchangeRates(): Boolean = try {
        val exchangeRates = api.get().body()

        exchangeRates?.let {
            sharedPref.putExchangeRates(it)
        }

        exchangeRates != null
    } catch (e: Exception) {
        false
    }
}