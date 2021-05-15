package dev.sertan.android.harcamatakip.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.databinding.ItemExpenseBinding
import dev.sertan.android.harcamatakip.view.adapter.ExpenseViewHolder.Callback
import dev.sertan.android.harcamatakip.view.ui.HomeFragmentDirections
import javax.inject.Inject

class ExpenseAdapter @Inject constructor() :
    ListAdapter<Expense, ExpenseViewHolder>(ExpenseDiffUtilCallback()) {

    var exchangeRate: ExchangeRate? = null
        set(value) {
            if (field != value) field = value.also { notifyDataSetChanged() }
        }

    var currency: Currency? = null
        set(value) {
            if (field != value) field = value.also { notifyDataSetChanged() }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder =
        DataBindingUtil
            .inflate<ItemExpenseBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_expense,
                parent,
                false
            )
            .run { ExpenseViewHolder(this) }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) =
        holder.bind(getItem(position), currency, exchangeRate)
}

class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(expense: Expense, currency: Currency?, exchangeRate: ExchangeRate?) {
        binding.apply {
            this.expense = expense
            this.currency = currency
            this.exchangeRate = exchangeRate
            callback = Callback {
                HomeFragmentDirections.homeToExpenseDetail(expense)
                    .run { root.findNavController().navigate(this) }
            }
        }
        binding.executePendingBindings()
    }

    fun interface Callback {
        fun goToDetailsFragment()
    }
}

private class ExpenseDiffUtilCallback : DiffUtil.ItemCallback<Expense>() {

    override fun areItemsTheSame(old: Expense, new: Expense) = old.uid == new.uid

    override fun areContentsTheSame(old: Expense, new: Expense) = old == new
}