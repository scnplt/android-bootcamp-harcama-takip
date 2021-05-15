package dev.sertan.android.harcamatakip.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.sertan.android.harcamatakip.data.model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDao

    companion object {
        fun create(context: Context): ExpenseDatabase = Room.databaseBuilder(
            context,
            ExpenseDatabase::class.java,
            ExpenseDatabase::class.java.name
        ).build()
    }
}