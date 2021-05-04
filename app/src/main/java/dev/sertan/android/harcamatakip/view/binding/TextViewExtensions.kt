package dev.sertan.android.harcamatakip.view.binding

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.Currency
import dev.sertan.android.harcamatakip.service.model.Gender
import dev.sertan.android.harcamatakip.service.model.User
import dev.sertan.android.harcamatakip.util.CurrencyConverter

@BindingAdapter("personal_titles")
fun AppCompatTextView.personalTitles(user: User) {
    val titleId = when (user.gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    text = resources.getString(titleId, user.name)
}

@BindingAdapter("calculate_amount", "calculate_exchange_rates", "calculate_by_currency")
fun AppCompatTextView.calculateAmount(
    amount: Double,
    exchangeRates: Map<String, Double>,
    currency: Currency
) {
    val total = CurrencyConverter.convert(amount, exchangeRates, currency)

    val currencySymbolId = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    text = resources.getString(currencySymbolId, total)
}