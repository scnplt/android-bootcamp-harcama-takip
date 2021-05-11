package dev.sertan.android.harcamatakip.view.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.view.ui.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.OnboardingViewModel

@AndroidEntryPoint
class OnboardingCurrencyFragment :
    BaseFragment<FragmentOnboardingCurrencyBinding>(R.layout.fragment_onboarding_currency) {
    private val viewModel: OnboardingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}