package dev.sertan.android.harcamatakip.data.api

import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.util.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateApi {
    @GET("latest")
    fun get(
        @Query("base") base: String = Currency.LIRA,
        @Query("symbols") symbols: String = "${Currency.DOLLAR},${Currency.EURO},${Currency.POUND}"
    ): Call<ExchangeRate>
}
