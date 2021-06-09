package dev.sertan.android.harcamatakip.view.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.data.model.Gender
import dev.sertan.android.harcamatakip.data.model.SpendCategory
import dev.sertan.android.harcamatakip.data.model.User

// Image View Adapters
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

// Text View Adapters
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
    val cost = if (expense != null) {
        calculateCost(expense.cost, exchangeRate, expense.currency, currency)
    } else {
        expenses?.sumOf { calculateCost(it.cost, exchangeRate, it.currency, currency) } ?: 0.0
    }
    val currencySymbol = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }
    view.text = view.resources.getString(currencySymbol, cost)
}

private fun calculateCost(
    value: Double = 0.0,
    exchangeRate: ExchangeRate?,
    from: Currency?,
    to: Currency?
): Double {
    val baseCurrencyRate = exchangeRate?.data?.get(from?.code) ?: 1.0
    val targetCurrencyRate = exchangeRate?.data?.get(to?.code) ?: 1.0
    return value * targetCurrencyRate / baseCurrencyRate
}

@BindingAdapter("defaultText")
fun bindDefaultText(view: TextView, mText: String) {
    with(view) {
        text = if (mText.isBlank()) resources.getText(R.string.default_description) else mText
    }
}

// Recycler View Adapters
@BindingAdapter("expenses", "currency", "exchangeRate", requireAll = false)
fun bindExpenses(
    view: RecyclerView,
    expenses: List<Expense>?,
    mCurrency: Currency?,
    mExchangeRate: ExchangeRate?
) {
    if (view.adapter !is ExpenseAdapter) return

    with(view.adapter as ExpenseAdapter) {
        submitList(expenses)
        currency = mCurrency
        exchangeRate = mExchangeRate
    }
}

// View Pager 2 Adapters
@BindingAdapter("tabLayout")
fun bindTabLayout(viewPager: ViewPager2, tabLayout: TabLayout) =
    TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

@BindingAdapter("pagerEndButton")
fun bindButton(viewPager: ViewPager2, button: Button) {
    if (viewPager.adapter !is OnboardingPagerAdapter) return

    val pageSize = (viewPager.adapter as OnboardingPagerAdapter).itemCount
    val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            button.visibility = if (position == pageSize - 1) View.VISIBLE else View.INVISIBLE
        }
    }
    viewPager.registerOnPageChangeCallback(pageChangeCallback)
}
