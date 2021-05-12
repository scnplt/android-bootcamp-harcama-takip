package dev.sertan.android.harcamatakip.view.binding.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.service.model.SpendCategory

object ImageViewAdapters {
    @JvmStatic
    @BindingAdapter("show_expense_icon")
    fun AppCompatImageView.showExpenseIcon(category: SpendCategory) {
        val iconID = getCategoryIconId(category)
        setImageResource(iconID)
    }

    private fun getCategoryIconId(category: SpendCategory) = when (category) {
        SpendCategory.BILL -> R.drawable.ic_bill
        SpendCategory.RENT -> R.drawable.ic_home
        SpendCategory.SHOP -> R.drawable.ic_shop
        else -> R.drawable.ic_hand
    }
}