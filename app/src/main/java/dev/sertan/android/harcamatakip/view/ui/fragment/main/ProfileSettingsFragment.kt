package dev.sertan.android.harcamatakip.view.ui.fragment.main

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentProfileSettingsBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment

class ProfileSettingsFragment : BaseFragment<FragmentProfileSettingsBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentProfileSettingsBinding =
        FragmentProfileSettingsBinding.inflate(layoutInflater)
}