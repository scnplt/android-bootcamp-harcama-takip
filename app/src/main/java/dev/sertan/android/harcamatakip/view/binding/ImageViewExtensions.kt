package dev.sertan.android.harcamatakip.view.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.Expense

@BindingAdapter("show_expense_icon")
fun AppCompatImageView.showExpenseIcon(expense: Expense) {
    val iconID = when (expense.type) {
        Expense.Companion.Type.BILL -> R.drawable.bill
        Expense.Companion.Type.RENT -> R.drawable.home
        Expense.Companion.Type.SHOP -> R.drawable.shop
        else -> R.drawable.hand
    }

    setImageResource(iconID)
}