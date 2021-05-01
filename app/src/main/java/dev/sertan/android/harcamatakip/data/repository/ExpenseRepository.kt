package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.asLiveData
import dev.sertan.android.harcamatakip.data.database.dao.ExpenseDAO
import dev.sertan.android.harcamatakip.data.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val dao: ExpenseDAO) {
    val expenses = dao.getAllExpenses().asLiveData()

    suspend fun add(expense: Expense) = dao.insert(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)
}