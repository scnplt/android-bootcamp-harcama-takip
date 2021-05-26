package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentSettingsBinding
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.SettingsViewModel

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {
    private val viewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}
