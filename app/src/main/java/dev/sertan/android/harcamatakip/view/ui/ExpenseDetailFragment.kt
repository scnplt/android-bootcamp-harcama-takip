package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentDetailExpenseBinding
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.ExpenseDetailViewModel

@AndroidEntryPoint
class ExpenseDetailFragment :
    BaseFragment<FragmentDetailExpenseBinding>(R.layout.fragment_detail_expense) {

    private val viewModel: ExpenseDetailViewModel by viewModels()
    private val args: ExpenseDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.expense = args.expense
    }
}