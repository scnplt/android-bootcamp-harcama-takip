package dev.sertan.android.harcamatakip.data.api

import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateAPI {
    @GET(ExchangeRateAPISettings.ENDPOINT)
    suspend fun get(
        @Query("base") base: String = ExchangeRateAPISettings.BASE_CURRENCY,
        @Query("symbols") symbols: String = ExchangeRateAPISettings.CURRENCIES
    ): Response<ExchangeRate>
}
