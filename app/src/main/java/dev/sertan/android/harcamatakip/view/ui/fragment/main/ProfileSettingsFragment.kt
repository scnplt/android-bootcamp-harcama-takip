package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentProfileSettingsBinding
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.ProfileSettingsViewModel

@AndroidEntryPoint
class ProfileSettingsFragment :
    BaseFragment<FragmentProfileSettingsBinding>(R.layout.fragment_profile_settings) {

    private val viewModel: ProfileSettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}