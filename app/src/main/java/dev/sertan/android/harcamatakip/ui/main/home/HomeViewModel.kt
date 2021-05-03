package dev.sertan.android.harcamatakip.ui.main.home

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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepo: UserRepository,
    exchangeRateRepo: ExchangeRateRepository,
    expenseRepo: ExpenseRepository
) : ViewModel() {

    var user: LiveData<User> = userRepo.user
    var expenses: LiveData<List<Expense>> = expenseRepo.expenses
    var exchangeRate: LiveData<ExchangeRate> = exchangeRateRepo.exchangeRates

    fun selectCurrency(currency: Currency) =
        userRepo.updateUser(user.value!!.apply { mainCurrency = currency })

    fun goToAddExpenseScreen(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddExpenseFragment()
        view.findNavController().navigate(action)
    }
}