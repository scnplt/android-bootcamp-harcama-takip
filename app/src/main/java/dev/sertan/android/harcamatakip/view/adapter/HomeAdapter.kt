package dev.sertan.android.harcamatakip.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.model.Expense
import dev.sertan.android.harcamatakip.databinding.ListItemExpenseBinding
import dev.sertan.android.harcamatakip.viewmodel.HomeViewModel

class HomeAdapter(private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val diffUtilCallback = object : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean =
            oldItem.uid == newItem.uid

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean =
            oldItem == newItem
    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtilCallback)

    var expenses: List<Expense>
        get() = asyncListDiffer.currentList
        set(value) = asyncListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemExpenseBinding>(
            inflater,
            R.layout.list_item_expense,
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.expense = expenses[position]
        holder.binding.viewModel = viewModel
    }

    override fun getItemCount(): Int = expenses.size

    class HomeViewHolder(val binding: ListItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root)
}