package dev.sertan.android.harcamatakip.ui.main.add

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentAddExpenseBinding =
        FragmentAddExpenseBinding.inflate(layoutInflater)
}