package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dev.sertan.android.harcamatakip.data.database.ExpenseDao
import dev.sertan.android.harcamatakip.data.model.Expense
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepository @Inject constructor(private val dao: ExpenseDao) {
    val expenses: LiveData<List<Expense>> = dao.getAllExpenses().asLiveData()

    suspend fun add(expense: Expense) = dao.insert(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)
}