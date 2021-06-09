package dev.sertan.android.harcamatakip.util

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.api.ExchangeRateService
import dev.sertan.android.harcamatakip.data.database.ExpenseDao
import dev.sertan.android.harcamatakip.data.database.ExpenseDatabase
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPref
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideExchangeRateService(moshi: Moshi): ExchangeRateService =
        ExchangeRateService.create(moshi)

    @Provides
    @Singleton
    fun provideExpenseDatabase(@ApplicationContext context: Context): ExpenseDatabase =
        ExpenseDatabase.create(context)

    @Provides
    @Singleton
    fun provideExpenseDao(db: ExpenseDatabase): ExpenseDao = db.expenseDao()

    @Provides
    @Singleton
    fun provideUserSharedPref(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): BaseSharedPref<User> {
        val dataClass = User::class.java
        return BaseSharedPref(context, dataClass, moshi.adapter(dataClass))
    }

    @Provides
    @Singleton
    fun provideExchangeRateSharedPref(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): BaseSharedPref<ExchangeRate> {
        val dataClass = ExchangeRate::class.java
        return BaseSharedPref(context, dataClass, moshi.adapter(dataClass))
    }
}
