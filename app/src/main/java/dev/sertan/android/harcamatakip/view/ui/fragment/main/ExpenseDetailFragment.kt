package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentExpenseDetailBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment

class ExpenseDetailFragment : BaseFragment<FragmentExpenseDetailBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentExpenseDetailBinding =
        FragmentExpenseDetailBinding.inflate(layoutInflater)
}