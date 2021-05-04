package dev.sertan.android.harcamatakip.service.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.service.api.ExchangeRateApi
import dev.sertan.android.harcamatakip.service.api.ExchangeRateApiSettings
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideExchangeRateAPI(): ExchangeRateApi = Retrofit.Builder()
        .baseUrl(ExchangeRateApiSettings.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ExchangeRateApi::class.java)
}