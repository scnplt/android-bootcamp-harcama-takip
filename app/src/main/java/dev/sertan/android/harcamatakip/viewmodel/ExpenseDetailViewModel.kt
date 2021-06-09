package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.data.repository.ExchangeRateRepo
import dev.sertan.android.harcamatakip.data.repository.ExpenseRepo
import dev.sertan.android.harcamatakip.data.repository.UserRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseDetailViewModel
@Inject constructor(
    private val expenseRepo: ExpenseRepo,
    private val exchangeRateRepo: ExchangeRateRepo,
    userRepo: UserRepo
) : ViewModel() {
    val exchangeRates: LiveData<ExchangeRate> get() = exchangeRateRepo.exchangeRates
    val baseCurrency: Currency = userRepo.user.value!!.baseCurrency

    fun deleteExpense(view: View, expense: Expense) {
        CoroutineScope(Dispatchers.IO).launch { expenseRepo.delete(expense) }
        view.findNavController().popBackStack()
    }
}
