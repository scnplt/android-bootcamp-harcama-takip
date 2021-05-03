package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentHomeBinding
import dev.sertan.android.harcamatakip.view.adapter.HomeAdapter
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(container: ViewGroup?): FragmentHomeBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.expenses.layoutManager = LinearLayoutManager(requireContext())
        binding.expenses.adapter = HomeAdapter(viewModel)
    }
}