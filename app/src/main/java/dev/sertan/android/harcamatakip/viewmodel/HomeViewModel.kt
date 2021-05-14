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

    val exchangeRate: LiveData<ExchangeRate> get() = exchangeRateRepo.exchangeRates

    val expenses: LiveData<List<Expense>> get() = expenseRepo.expenses

    fun selectCurrency(currency: Currency) =
        userRepo.updateUser(user.value!!.apply { baseCurrency = currency })

    fun goToAddExpenseScreen(view: View) {
        val action = HomeFragmentDirections.actionHomeToAddExpense()
        view.findNavController().navigate(action)
    }

    fun goToExpenseDetailScreen(view: View, expense: Expense) {
        val action = HomeFragmentDirections.actionHomeToExpenseDetail(expense)
        view.findNavController().navigate(action)
    }

    fun goToSettingsScreen(view: View) {
        val action = HomeFragmentDirections.actionHomeToProfileSettings()
        view.findNavController().navigate(action)
    }
}