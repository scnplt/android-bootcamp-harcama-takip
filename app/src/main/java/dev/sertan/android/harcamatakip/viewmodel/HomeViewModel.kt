package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.service.model.User
import dev.sertan.android.harcamatakip.service.repository.ExchangeRateRepository
import dev.sertan.android.harcamatakip.service.repository.ExpenseRepository
import dev.sertan.android.harcamatakip.service.repository.UserRepository
import dev.sertan.android.harcamatakip.view.ui.fragment.main.HomeFragmentDirections
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
        val action = HomeFragmentDirections.actionHomeFragmentToAddExpenseFragment()
        view.findNavController().navigate(action)
    }

    fun goToExpenseDetailScreen(view: View, expense: Expense) {
        val action = HomeFragmentDirections.actionHomeFragmentToExpenseDetailFragment(expense)
        view.findNavController().navigate(action)
    }

    fun goToSettingsScreen(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileSettingsFragment()
        view.findNavController().navigate(action)
    }
}