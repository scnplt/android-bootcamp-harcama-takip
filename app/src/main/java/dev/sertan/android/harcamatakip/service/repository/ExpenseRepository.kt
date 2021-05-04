package dev.sertan.android.harcamatakip.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dev.sertan.android.harcamatakip.service.database.ExpenseDao
import dev.sertan.android.harcamatakip.service.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val dao: ExpenseDao) {
    val expenses: LiveData<List<Expense>> = dao.getAllExpenses().asLiveData()

    suspend fun add(expense: Expense) = dao.insert(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)
}