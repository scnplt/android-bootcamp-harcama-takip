package dev.sertan.android.harcamatakip.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.sertan.android.harcamatakip.data.database.dao.ExpenseDAO
import dev.sertan.android.harcamatakip.data.model.Expense

@TypeConverters(Expense.Companion.Converter::class)
@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDAO
}