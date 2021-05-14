package dev.sertan.android.harcamatakip.view.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.model.*

@BindingAdapter("categoryIcon")
fun bindCategoryIcon(view: ImageView, category: SpendCategory) {
    val icon = when (category) {
        SpendCategory.BILL -> R.drawable.ic_bill
        SpendCategory.RENT -> R.drawable.ic_home
        SpendCategory.SHOP -> R.drawable.ic_shop
        else -> R.drawable.ic_hand
    }

    view.setImageResource(icon)
}

@BindingAdapter("userName")
fun bindUserName(view: TextView, user: User) {
    if (user.name.isBlank()) return

    val name = user.name.replaceFirstChar { it.uppercase() }
    val personalTitle = when (user.gender) {
        Gender.MAN -> R.string.personal_title_man
        Gender.WOMAN -> R.string.personal_title_woman
        else -> R.string.personal_title_unknown
    }

    view.text = view.resources.getString(personalTitle, name)
}

@BindingAdapter("expense", "expenses", "currency", "exchangeRate", requireAll = false)
fun bindCost(
    view: TextView,
    expense: Expense?,
    expenses: List<Expense>?,
    currency: Currency?,
    exchangeRate: ExchangeRate?
) {
    val cost: Double = expense?.amountConvert(exchangeRate, currency)
        ?: (expenses?.sumOf { it.amountConvert(exchangeRate, currency) } ?: 0.0)
    val currencySymbol = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    view.text = view.resources.getString(currencySymbol, cost)
}