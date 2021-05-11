package dev.sertan.android.harcamatakip.viewmodel.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.service.repository.ExchangeRateRepository
import dev.sertan.android.harcamatakip.service.repository.ExpenseRepository
import dev.sertan.android.harcamatakip.service.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseDetailViewModel @Inject constructor(
    private val expenseRepo: ExpenseRepository,
    private val exchangeRateRepo: ExchangeRateRepository,
    private val userRepo: UserRepository
) : ViewModel() {

    fun getBaseCurrency(): Currency = userRepo.user.value!!.baseCurrency

    val exchangeRates: LiveData<ExchangeRate> get() = exchangeRateRepo.exchangeRates

    fun deleteExpense(view: View, expense: Expense) = viewModelScope.launch {
        expenseRepo.delete(expense)
        view.findNavController().popBackStack()
    }
}