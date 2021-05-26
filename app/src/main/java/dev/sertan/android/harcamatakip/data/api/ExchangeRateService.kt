package dev.sertan.android.harcamatakip.data.api

import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateService {
    @GET(ENDPOINT)
    suspend fun get(
        @Query("base") base: String = BASE_CURRENCY.code,
        @Query("symbols") symbols: String = CURRENCIES.joinToString(",") { it.code }
    ): Response<ExchangeRate>

    companion object {
        private const val BASE_URL = "https://api.exchangerate.host/"
        private const val ENDPOINT = "latest"
        private val BASE_CURRENCY = Currency.LIRA
        private val CURRENCIES = Currency.values().filter { it != BASE_CURRENCY }

        fun create(): ExchangeRateService = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ExchangeRateService::class.java)
    }
}
