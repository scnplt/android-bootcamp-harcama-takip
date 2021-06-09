package dev.sertan.android.harcamatakip.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.model.Currency
import dev.sertan.android.harcamatakip.data.model.ExchangeRate
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.databinding.ItemExpenseBinding
import dev.sertan.android.harcamatakip.view.HomeFragmentDirections
import dev.sertan.android.harcamatakip.view.adapter.ExpenseViewHolder.Callback
import javax.inject.Inject

class ExpenseAdapter @Inject constructor() :
    ListAdapter<Expense, ExpenseViewHolder>(ExpenseDiffUtilCallback()) {

    var exchangeRate: ExchangeRate? = null
        set(value) {
            if (field != value) {
                field = value
                notifyDataSetChanged()
            }
        }

    var currency: Currency? = null
        set(value) {
            if (field != value) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil
            .inflate<ItemExpenseBinding>(inflater, R.layout.item_expense, parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) =
        holder.bind(getItem(position), currency, exchangeRate)
}

class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(mExpense: Expense, mCurrency: Currency?, mExchangeRate: ExchangeRate?) {
        binding.apply {
            expense = mExpense
            currency = mCurrency
            exchangeRate = mExchangeRate
            callback = Callback {
                val transitionName =
                    root.resources.getString(R.string.transition_expense_detail_card)
                val action = HomeFragmentDirections.homeToExpenseDetail(mExpense)
                val extras = FragmentNavigatorExtras(root to transitionName)
                root.findNavController().navigate(action, extras)
            }
        }.executePendingBindings()
    }

    fun interface Callback {
        fun goToDetailsFragment()
    }
}

private class ExpenseDiffUtilCallback : DiffUtil.ItemCallback<Expense>() {
    override fun areItemsTheSame(old: Expense, new: Expense): Boolean = old.uid == new.uid
    override fun areContentsTheSame(old: Expense, new: Expense): Boolean = old == new
}
