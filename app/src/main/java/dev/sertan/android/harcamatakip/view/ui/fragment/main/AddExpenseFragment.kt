package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment

class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentAddExpenseBinding =
        FragmentAddExpenseBinding.inflate(layoutInflater)
}