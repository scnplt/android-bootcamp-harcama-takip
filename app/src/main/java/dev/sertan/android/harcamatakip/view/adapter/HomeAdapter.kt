package dev.sertan.android.harcamatakip.view.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.RcvItemHomeExpenseBinding
import dev.sertan.android.harcamatakip.service.model.Expense
import dev.sertan.android.harcamatakip.viewmodel.HomeViewModel

class HomeAdapter(private val viewModel: HomeViewModel) :
    BaseAdapter<Expense, RcvItemHomeExpenseBinding>() {
    override val diffCallback = object : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean =
            oldItem.uid == newItem.uid

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean =
            oldItem == newItem
    }

    override fun getLayoutID(): Int = R.layout.rcv_item_home_expense

    override fun onBindViewHolder(holder: ViewHolder<RcvItemHomeExpenseBinding>, position: Int) {
        holder.binding.expense = data[position]
        holder.binding.viewModel = viewModel
    }
}