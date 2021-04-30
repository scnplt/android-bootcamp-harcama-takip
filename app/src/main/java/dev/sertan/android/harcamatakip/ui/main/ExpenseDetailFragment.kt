package dev.sertan.android.harcamatakip.ui.main

import dev.sertan.android.harcamatakip.databinding.FragmentExpenseDetailBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class ExpenseDetailFragment : BaseFragment<FragmentExpenseDetailBinding>() {
    override fun getViewDataBinding(): FragmentExpenseDetailBinding =
        FragmentExpenseDetailBinding.inflate(layoutInflater)
}