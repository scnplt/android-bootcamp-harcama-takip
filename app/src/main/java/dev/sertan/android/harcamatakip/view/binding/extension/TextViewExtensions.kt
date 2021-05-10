package dev.sertan.android.harcamatakip.view.binding.extension

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.*

@BindingAdapter("show_name")
fun AppCompatTextView.showName(user: User) {
    if (user.name.isBlank()) return

    val titleId = when (user.gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    text = resources.getString(titleId, user.name.replaceFirstChar { it.uppercase() })
}

@BindingAdapter("expense", "expenses", "currency", "exchange_rate", requireAll = false)
fun AppCompatTextView.shotAmount(
    expense: Expense?,
    expenses: List<Expense>?,
    currency: Currency?,
    exchangeRate: ExchangeRate?
) {
    val currencySymbolId: Int? = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        Currency.LIRA -> R.string.lira_with_symbol
        else -> null
    }

    val amount: Double = expense?.amountConvert(exchangeRate, currency)
        ?: (expenses?.sumOf { it.amountConvert(exchangeRate, currency) } ?: 0.0)

    text = if (currencySymbolId != null) resources.getString(currencySymbolId, amount)
    else amount.toString()
}