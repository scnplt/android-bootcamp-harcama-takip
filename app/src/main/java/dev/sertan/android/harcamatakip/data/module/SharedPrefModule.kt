package dev.sertan.android.harcamatakip.data.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPreferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {
    @Provides
    @Singleton
    fun getUserSharedPref(@ApplicationContext context: Context): BaseSharedPreferences<User> =
        BaseSharedPreferences(context, User::class.java)

    @Provides
    @Singleton
    fun getExchangeRateSharedPref(@ApplicationContext context: Context): BaseSharedPreferences<ExchangeRate> =
        BaseSharedPreferences(context, ExchangeRate::class.java)
}
