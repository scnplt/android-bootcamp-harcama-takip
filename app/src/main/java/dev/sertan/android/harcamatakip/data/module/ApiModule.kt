package dev.sertan.android.harcamatakip.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.api.ExchangeRateService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun getExchangeRateService(): ExchangeRateService = ExchangeRateService.create()
}
