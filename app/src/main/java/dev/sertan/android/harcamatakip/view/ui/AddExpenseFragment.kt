package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentExpenseAddBinding
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.AddExpsenseViewModel

@AndroidEntryPoint
class AddExpenseFragment : BaseFragment<FragmentExpenseAddBinding>(R.layout.fragment_expense_add) {
    private val viewModel: AddExpsenseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}
