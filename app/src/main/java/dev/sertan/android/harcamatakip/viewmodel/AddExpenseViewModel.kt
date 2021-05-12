package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.service.model.SpendCategory
import dev.sertan.android.harcamatakip.service.repository.ExpenseRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val expenseRepo: ExpenseRepository
) : ViewModel() {

    private val _expense = MutableLiveData(Expense())
    val expense: LiveData<Expense> get() = _expense

    fun selectCurrency(currency: Currency) {
        expense.value!!.currency = currency
    }

    fun selectType(category: SpendCategory) {
        expense.value!!.category = category
    }

    fun save(view: View) = viewModelScope.launch {
        expenseRepo.add(expense.value!!)
        view.findNavController().popBackStack()
    }
}