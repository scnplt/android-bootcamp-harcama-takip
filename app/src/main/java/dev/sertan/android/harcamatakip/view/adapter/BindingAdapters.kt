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
import dev.sertan.android.harcamatakip.data.model.*

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
    val cost: Double = expense?.costConvert(exchangeRate, currency)
        ?: (expenses?.sumOf { it.costConvert(exchangeRate, currency) } ?: 0.0)
    val currencySymbol = when (currency) {
        Currency.EURO -> R.string.euro_with_symbol
        Currency.POUND -> R.string.pound_with_symbol
        Currency.DOLLAR -> R.string.dollar_with_symbol
        else -> R.string.lira_with_symbol
    }

    view.text = view.resources.getString(currencySymbol, cost)
}

@BindingAdapter("defaultText")
fun bindDefaultText(view: TextView, text: String) {
    with(view) {
        this.text = if (text.isBlank()) resources.getText(R.string.default_desc) else text
    }
}

// Recycler View Adapters
@BindingAdapter("expenses", "currency", "exchangeRate", requireAll = false)
fun bindExpenses(
    view: RecyclerView,
    expenses: List<Expense>?,
    currency: Currency?,
    exchangeRate: ExchangeRate?
) {
    if (view.adapter !is ExpenseAdapter) return

    with(view.adapter as ExpenseAdapter) {
        submitList(expenses)
        this.currency = currency
        this.exchangeRate = exchangeRate
    }
}

// View Adapters
@BindingAdapter("isVisible")
fun bindIsVisible(view: View, isVisible: Boolean?) = isVisible?.let {
    view.visibility = if (it) View.VISIBLE else View.INVISIBLE
}

// View Pager 2 Adapters
@BindingAdapter("tabLayout")
fun bindTabLayout(viewPager: ViewPager2, tabLayout: TabLayout) =
    TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

@BindingAdapter("pagerEndButton")
fun bindButton(viewPager: ViewPager2, button: Button) {
    if (viewPager.adapter !is OnboardingPagerAdapter) return

    val pageSize = (viewPager.adapter as OnboardingPagerAdapter).itemCount
    viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            button.visibility = if (position == pageSize - 1) View.VISIBLE else View.INVISIBLE
        }
    })
}