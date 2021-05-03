package dev.sertan.android.harcamatakip.ui.main.profile

import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentProfileSettingsBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class ProfileSettingsFragment : BaseFragment<FragmentProfileSettingsBinding>() {
    override fun getViewBinding(container: ViewGroup?): FragmentProfileSettingsBinding =
        FragmentProfileSettingsBinding.inflate(layoutInflater)
}