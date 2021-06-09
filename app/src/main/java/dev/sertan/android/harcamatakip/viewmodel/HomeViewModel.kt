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
import dev.sertan.android.harcamatakip.data.repository.ExchangeRateRepo
import dev.sertan.android.harcamatakip.data.repository.ExpenseRepo
import dev.sertan.android.harcamatakip.data.repository.UserRepo
import dev.sertan.android.harcamatakip.view.HomeFragmentDirections
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepo: UserRepo,
    private val expenseRepo: ExpenseRepo,
    private val exchangeRateRepo: ExchangeRateRepo
) : ViewModel() {
    val user: LiveData<User> get() = userRepo.user
    val expenses: LiveData<List<Expense>> get() = expenseRepo.expenses
    val exchangeRate: LiveData<ExchangeRate> get() = exchangeRateRepo.exchangeRates

    fun isCurrency(currency: Currency) = currency == user.value!!.baseCurrency

    fun updateCurrency(currency: Currency) =
        userRepo.updateUser(user.value!!.apply { baseCurrency = currency })

    fun goToSettingsFragment(view: View) = HomeFragmentDirections.homeToSettings()
        .let { view.findNavController().navigate(it) }

    fun goToAddExpenseFragment(view: View) = HomeFragmentDirections.homeToAddExpense()
        .let { view.findNavController().navigate(it) }
}
