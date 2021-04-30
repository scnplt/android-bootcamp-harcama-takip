package dev.sertan.android.harcamatakip.ui.main

import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>() {
    override fun getViewDataBinding(): FragmentAddExpenseBinding =
        FragmentAddExpenseBinding.inflate(layoutInflater)
}