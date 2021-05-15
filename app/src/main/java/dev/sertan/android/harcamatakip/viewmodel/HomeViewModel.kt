package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.repository.ExchangeRateRepository
import dev.sertan.android.harcamatakip.data.repository.ExpenseRepository
import dev.sertan.android.harcamatakip.data.repository.UserRepository
import dev.sertan.android.harcamatakip.view.ui.HomeFragmentDirections
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepo: UserRepository,
    private val expenseRepo: ExpenseRepository,
    private val exchangeRateRepo: ExchangeRateRepository
) : ViewModel() {

    val user: LiveData<User> get() = userRepo.user
    val expenses: LiveData<List<Expense>> get() = expenseRepo.expenses
    val exchangeRate: LiveData<ExchangeRate> get() = exchangeRateRepo.exchangeRates

    fun isCurrency(currency: Currency) = currency == user.value!!.baseCurrency

    fun updateCurrency(currency: Currency) =
        userRepo.updateUser(user.value!!.apply { baseCurrency = currency })

    fun goToSettingsFragment(view: View) = HomeFragmentDirections.homeToSettings()
        .run { view.findNavController().navigate(this) }

    fun goToAddExpenseFragment(view: View) = HomeFragmentDirections.homeToAddExpense()
        .run { view.findNavController().navigate(this) }
}