package dev.sertan.android.harcamatakip.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.sertan.android.harcamatakip.service.model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDao
}