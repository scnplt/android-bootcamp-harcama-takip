package dev.sertan.android.harcamatakip.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.api.ExchangeRateAPI
import dev.sertan.android.harcamatakip.data.api.ExchangeRateAPISettings
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object APIModule {
    @Provides
    fun provideExchangeRateAPI(): ExchangeRateAPI = Retrofit.Builder()
        .baseUrl(ExchangeRateAPISettings.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ExchangeRateAPI::class.java)
}