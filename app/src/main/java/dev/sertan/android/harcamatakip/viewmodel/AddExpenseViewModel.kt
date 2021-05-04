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
import dev.sertan.android.harcamatakip.service.repository.ExchangeRateRepository
import dev.sertan.android.harcamatakip.service.repository.ExpenseRepository
import dev.sertan.android.harcamatakip.util.CurrencyConverter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val expenseRepo: ExpenseRepository,
    private val exchangeRateRepo: ExchangeRateRepository
) : ViewModel() {

    private val _expense = MutableLiveData(Expense())
    val expense: LiveData<Expense> by ::_expense

    private val _currency = MutableLiveData(Currency.LIRA)
    val currency: LiveData<Currency> by ::_currency

    fun selectCurrency(currency: Currency) = this._currency.postValue(currency)

    fun selectType(category: SpendCategory) {
        _expense.value!!.category = category
    }

    fun save(view: View) = viewModelScope.launch {
        val mExpense = expense.value!!
        mExpense.amount = CurrencyConverter.convert(
            mExpense.amount,
            exchangeRateRepo.exchangeRates.value!!.rates,
            from = currency.value!!
        )
        expenseRepo.add(mExpense)
        view.findNavController().popBackStack()
    }
}