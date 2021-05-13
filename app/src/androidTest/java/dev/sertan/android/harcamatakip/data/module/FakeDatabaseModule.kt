package dev.sertan.android.harcamatakip.data.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import dev.sertan.android.harcamatakip.data.database.ExpenseDatabase

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
object FakeDatabaseModule {
    @Provides
    fun provideExpenseDatabase(@ApplicationContext context: Context): ExpenseDatabase =
        Room.inMemoryDatabaseBuilder(context, ExpenseDatabase::class.java).build()
}