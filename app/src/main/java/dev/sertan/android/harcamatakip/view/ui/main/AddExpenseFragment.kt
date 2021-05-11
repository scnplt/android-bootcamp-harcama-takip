package dev.sertan.android.harcamatakip.view.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentAddExpenseBinding
import dev.sertan.android.harcamatakip.view.ui.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.main.AddExpenseViewModel

@AndroidEntryPoint
class AddExpenseFragment : BaseFragment<FragmentAddExpenseBinding>(R.layout.fragment_add_expense) {
    private val viewModel: AddExpenseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}