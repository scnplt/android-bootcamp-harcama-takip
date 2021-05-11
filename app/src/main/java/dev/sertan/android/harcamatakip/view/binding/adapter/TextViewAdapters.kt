package dev.sertan.android.harcamatakip.view.binding.adapter

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.*

object TextViewAdapters {
    @JvmStatic
    @BindingAdapter("show_name")
    fun AppCompatTextView.showName(user: User) {
        if (user.name.isBlank()) return

        val titleId = getPersonalTitleId(user.gender)
        val name = user.name.replaceFirstChar { it.uppercase() }
        text = resources.getString(titleId, name)
    }

    @JvmStatic
    @BindingAdapter("expense", "expenses", "currency", "exchange_rate", requireAll = false)
    fun AppCompatTextView.showAmount(
        expense: Expense?,
        expenses: List<Expense>?,
        currency: Currency?,
        exchangeRate: ExchangeRate?
    ) {
        val currencySymbolId = getCurrencySymbolId(currency)
        val amount: Double = expense?.amountConvert(exchangeRate, currency)
            ?: (expenses?.sumOf { it.amountConvert(exchangeRate, currency) } ?: 0.0)

        text = resources.getString(currencySymbolId, amount)
    }

    private fun getPersonalTitleId(gender: Gender?) = when (gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    private fun getCurrencySymbolId(currency: Currency?) = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }
}