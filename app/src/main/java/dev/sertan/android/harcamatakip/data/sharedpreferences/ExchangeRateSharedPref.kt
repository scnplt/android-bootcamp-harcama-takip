package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import androidx.lifecycle.LiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import javax.inject.Inject

class ExchangeRateSharedPref @Inject constructor(@ApplicationContext context: Context) :
    BaseSharedPreferences<ExchangeRate>(context, ExchangeRate::class.java) {

    val exchangeRates: LiveData<ExchangeRate> get() = data

    fun updateExchangeRates(exchangeRate: ExchangeRate) = updateData(exchangeRate)
}