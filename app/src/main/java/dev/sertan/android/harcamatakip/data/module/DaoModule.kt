package dev.sertan.android.harcamatakip.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.database.ExpenseDao
import dev.sertan.android.harcamatakip.data.database.ExpenseDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun getExpenseDao(db: ExpenseDatabase): ExpenseDao = db.expenseDAO()
}
