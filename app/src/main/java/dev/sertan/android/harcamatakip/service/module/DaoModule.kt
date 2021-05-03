package dev.sertan.android.harcamatakip.service.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.service.database.ExpenseDao
import dev.sertan.android.harcamatakip.service.database.ExpenseDatabase

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun provideExpenseDAO(db: ExpenseDatabase): ExpenseDao = db.expenseDAO()
}