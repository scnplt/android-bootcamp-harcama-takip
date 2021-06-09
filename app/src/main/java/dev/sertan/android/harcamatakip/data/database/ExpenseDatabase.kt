package dev.sertan.android.harcamatakip.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.sertan.android.harcamatakip.data.model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {
        fun create(context: Context): ExpenseDatabase {
            val dataClass = ExpenseDatabase::class.java
            return Room.databaseBuilder(context, dataClass, dataClass.name).build()
        }
    }
}
