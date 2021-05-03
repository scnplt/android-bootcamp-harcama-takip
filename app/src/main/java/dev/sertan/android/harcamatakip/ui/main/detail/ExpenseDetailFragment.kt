package dev.sertan.android.harcamatakip.ui.main.detail

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentExpenseDetailBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class ExpenseDetailFragment : BaseFragment<FragmentExpenseDetailBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentExpenseDetailBinding =
        FragmentExpenseDetailBinding.inflate(layoutInflater)
}