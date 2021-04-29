package dev.sertan.android.harcamatakip.ui.main

import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.ui.BaseFragment

class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>() {
    override fun getViewDataBinding(): FragmentAddExpenseBinding =
        FragmentAddExpenseBinding.inflate(layoutInflater)
}