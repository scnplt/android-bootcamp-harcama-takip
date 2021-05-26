package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentHomeBinding
import dev.sertan.android.harcamatakip.view.adapter.ExpenseAdapter
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.HomeViewModel
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    @Inject
    lateinit var adapter: ExpenseAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        binding.viewModel = homeViewModel
        binding.expenses.adapter = adapter
    }
}
