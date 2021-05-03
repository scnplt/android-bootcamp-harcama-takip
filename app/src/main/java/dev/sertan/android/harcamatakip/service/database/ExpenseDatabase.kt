package dev.sertan.android.harcamatakip.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.sertan.android.harcamatakip.service.model.Expense

@TypeConverters(Expense.Companion.Converter::class)
@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDao
}