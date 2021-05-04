package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.AddExpenseViewModel

@AndroidEntryPoint
class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>() {
    private val viewModel: AddExpenseViewModel by viewModels()

    override fun getViewBinding(container: ViewGroup?): FragmentAddExpenseBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_expense, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}