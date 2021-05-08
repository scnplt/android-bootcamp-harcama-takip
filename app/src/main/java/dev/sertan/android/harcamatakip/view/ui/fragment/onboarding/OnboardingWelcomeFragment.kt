package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingWelcomeBinding
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment

class OnboardingWelcomeFragment :
    BaseFragment<FragmentOnboardingWelcomeBinding>(R.layout.fragment_onboarding_welcome),
    OnboardingListener {

    override fun skipButtonOnClickListener(view: View) {
        val action = OnboardingWelcomeFragmentDirections
            .actionOnboardingWelcomeFragmentToOnboardingCategoryFragment()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
    }
}