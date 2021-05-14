package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentHomeBinding
import dev.sertan.android.harcamatakip.view.adapter.HomeAdapter
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        adapter = HomeAdapter(viewModel)

        setupListeners()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.expenses.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
        binding.expenses.adapter = adapter
    }

    private fun setupListeners() {
        viewModel.expenses.observe(viewLifecycleOwner) { adapter.expenses = it }
        viewModel.user.observe(viewLifecycleOwner) { adapter.notifyDataSetChanged() }
    }
}