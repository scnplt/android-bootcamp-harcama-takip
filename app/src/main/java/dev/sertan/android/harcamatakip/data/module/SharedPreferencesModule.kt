package dev.sertan.android.harcamatakip.data.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.ExchangeRateSharedPref

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Provides
    fun provideExchangeRateSharedPref(@ApplicationContext context: Context): ExchangeRateSharedPref =
        ExchangeRateSharedPref(context)
}