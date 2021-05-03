package dev.sertan.android.harcamatakip.view.binding

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.ExchangeRate
import dev.sertan.android.harcamatakip.service.model.Gender
import dev.sertan.android.harcamatakip.service.model.User

@BindingAdapter("personal_titles")
fun AppCompatTextView.personalTitles(user: User) {
    val titleID = when (user.gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    this.text = resources.getString(titleID, user.name)
}

@BindingAdapter("calculate_amount", "calculate_exchange_rate", "calculate_currency")
fun AppCompatTextView.calculateAmount(
    amount: Double,
    exchangeRate: ExchangeRate,
    currency: Currency
) {
    val ratio = exchangeRate.rates[currency.code] ?: 1.0
    val total = amount * ratio

    val currencySymbolID = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    val text = resources.getString(currencySymbolID, total)
    this.text = text
}