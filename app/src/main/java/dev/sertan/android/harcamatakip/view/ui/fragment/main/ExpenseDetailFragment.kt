package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentExpenseDetailBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.ExpenseDetailViewModel

@AndroidEntryPoint
class ExpenseDetailFragment : BaseFragment<FragmentExpenseDetailBinding>() {
    private val viewModel: ExpenseDetailViewModel by viewModels()
    private val args: ExpenseDetailFragmentArgs by navArgs()

    override fun getViewBinding(container: ViewGroup?): FragmentExpenseDetailBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_expense_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.expense = args.expense
        binding.viewModel = viewModel
    }
}