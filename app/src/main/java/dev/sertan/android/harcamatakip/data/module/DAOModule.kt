package dev.sertan.android.harcamatakip.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.database.ExpenseDatabase
import dev.sertan.android.harcamatakip.data.database.dao.ExpenseDAO

@Module
@InstallIn(SingletonComponent::class)
object DAOModule {
    @Provides
    fun provideExpenseDAO(db: ExpenseDatabase): ExpenseDAO = db.expenseDAO()
}