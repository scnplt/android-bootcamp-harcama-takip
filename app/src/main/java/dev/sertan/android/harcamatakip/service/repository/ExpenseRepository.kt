package dev.sertan.android.harcamatakip.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dev.sertan.android.harcamatakip.service.database.ExpenseDatabase
import dev.sertan.android.harcamatakip.service.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDatabase: ExpenseDatabase) {
    private val dao = expenseDatabase.expenseDAO()

    val expenses: LiveData<List<Expense>>
        get() = dao.getAllExpenses().asLiveData()

    suspend fun add(expense: Expense) = dao.insert(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)

    fun close() = expenseDatabase.close()
}