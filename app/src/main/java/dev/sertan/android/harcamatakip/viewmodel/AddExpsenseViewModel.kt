package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.data.model.SpendCategory
import dev.sertan.android.harcamatakip.data.repository.ExpenseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpsenseViewModel
@Inject constructor(private val expenseRepo: ExpenseRepository) : ViewModel() {
    val expense: LiveData<Expense> = MutableLiveData(Expense())

    fun isCurrency(currency: Currency) = currency == expense.value!!.currency

    fun isCategory(category: SpendCategory) = category == expense.value!!.category

    fun updateCurrency(currency: Currency) {
        expense.value!!.currency = currency
    }

    fun updateCategory(category: SpendCategory) {
        expense.value!!.category = category
    }

    fun saveExpense(view: View) {
        if (expense.value!!.cost != 0.0) {
            CoroutineScope(Dispatchers.IO).launch { expenseRepo.add(expense.value!!) }
        }
        view.findNavController().popBackStack()
    }
}
