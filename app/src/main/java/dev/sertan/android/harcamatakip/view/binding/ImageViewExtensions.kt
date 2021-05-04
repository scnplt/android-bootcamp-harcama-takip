package dev.sertan.android.harcamatakip.view.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.service.model.SpendCategory

@BindingAdapter("show_expense_icon")
fun AppCompatImageView.showExpenseIcon(expense: Expense) {
    val iconID = when (expense.category) {
        SpendCategory.BILL -> R.drawable.bill
        SpendCategory.RENT -> R.drawable.home
        SpendCategory.SHOP -> R.drawable.shop
        else -> R.drawable.hand
    }

    setImageResource(iconID)
}