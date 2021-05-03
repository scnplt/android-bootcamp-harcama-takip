package dev.sertan.android.harcamatakip.service.repository

import dev.sertan.android.harcamatakip.service.database.ExpenseDao
import dev.sertan.android.harcamatakip.service.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val dao: ExpenseDao) {
    val expenses = dao.getAllExpenses()

    suspend fun add(expense: Expense) = dao.insert(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)
}