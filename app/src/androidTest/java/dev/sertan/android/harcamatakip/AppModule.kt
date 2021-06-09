package dev.sertan.android.harcamatakip

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.sertan.android.harcamatakip.data.database.ExpenseDatabase
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @FakeExpenseDatabase
    fun provideExpenseDatabase(@ApplicationContext context: Context): ExpenseDatabase =
        Room.inMemoryDatabaseBuilder(context, ExpenseDatabase::class.java).build()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeExpenseDatabase
