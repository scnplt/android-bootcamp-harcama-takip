package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.service.repository.ExchangeRateRepository
import dev.sertan.android.harcamatakip.service.repository.ExpenseRepository
import dev.sertan.android.harcamatakip.service.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseDetailViewModel @Inject constructor(
    private val expenseRepo: ExpenseRepository,
    exchangeRateRepo: ExchangeRateRepository,
    userRepo: UserRepository
) : ViewModel() {

    val mainCurrency: LiveData<Currency> = Transformations.map(userRepo.user) { it.mainCurrency }
    val exchangeRates: LiveData<Map<String, Double>> =
        Transformations.map(exchangeRateRepo.exchangeRates) { it.rates }

    fun deleteExpense(view: View, expense: Expense) = viewModelScope.launch {
        expenseRepo.delete(expense)
        view.findNavController().popBackStack()
    }
}