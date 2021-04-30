package dev.sertan.android.harcamatakip.ui.main

import dev.sertan.android.harcamatakip.databinding.FragmentProfileSettingsBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class ProfileSettingsFragment : BaseFragment<FragmentProfileSettingsBinding>() {
    override fun getViewDataBinding(): FragmentProfileSettingsBinding =
        FragmentProfileSettingsBinding.inflate(layoutInflater)
}