package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
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
    exchangeRateRepo: ExchangeRateRepository,
    expenseRepo: ExpenseRepository
) : ViewModel() {

    val user: LiveData<User> = userRepo.user
    val expenses: LiveData<List<Expense>> = expenseRepo.expenses
    val exchangeRate: LiveData<ExchangeRate> = exchangeRateRepo.exchangeRates
    val totalAmount: LiveData<Double>
        get() = Transformations.map(expenses) { it.sumByDouble { e -> e.amount } }

    fun selectCurrency(currency: Currency) =
        userRepo.updateUser(user.value!!.apply { mainCurrency = currency })

    fun goToAddExpenseScreen(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddExpenseFragment()
        view.findNavController().navigate(action)
    }
}