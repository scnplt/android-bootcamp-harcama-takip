package dev.sertan.android.harcamatakip.service.api

import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateApi {
    @GET(ExchangeRateApiSettings.ENDPOINT)
    suspend fun get(
        @Query("base") base: String = ExchangeRateApiSettings.BASE_CURRENCY,
        @Query("symbols") symbols: String = ExchangeRateApiSettings.CURRENCIES
    ): Response<ExchangeRate>
}
