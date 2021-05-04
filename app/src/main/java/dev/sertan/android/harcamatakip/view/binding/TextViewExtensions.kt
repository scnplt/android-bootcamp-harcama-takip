package dev.sertan.android.harcamatakip.view.binding

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.*

@BindingAdapter("show_name")
fun AppCompatTextView.showName(user: User?) {
    if (user == null || user.name.isBlank()) return

    val titleId = when (user.gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    text = resources.getString(titleId, user.name)
}

@BindingAdapter("expense", "currency", "exchange_rate")
fun AppCompatTextView.showAmount(
    expense: Expense?,
    currency: Currency?,
    exchangeRate: ExchangeRate?
) {
    if (expense == null || currency == null || exchangeRate == null) return

    val currencySymbolId = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    val amount = expense.amountConvert(exchangeRate, currency)

    text = resources.getString(currencySymbolId, amount)
}

@BindingAdapter("expenses", "currency", "exchange_rate")
fun AppCompatTextView.showTotalAmount(
    expenses: List<Expense>?,
    currency: Currency?,
    exchangeRate: ExchangeRate?
) {
    if (expenses == null || currency == null || exchangeRate == null) return

    val currencySymbolId = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    val amount = expenses.sumOf { it.amountConvert(exchangeRate, currency) }

    text = resources.getString(currencySymbolId, amount)
}