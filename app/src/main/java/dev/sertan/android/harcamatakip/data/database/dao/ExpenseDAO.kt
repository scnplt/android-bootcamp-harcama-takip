package dev.sertan.android.harcamatakip.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.sertan.android.harcamatakip.data.model.Expense

@Dao
interface ExpenseDAO {
    @Query("SELECT * FROM expense_table")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Insert
    suspend fun insert(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)
}