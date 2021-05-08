package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.view.ui.activity.MainActivity
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment

class OnboardingCurrencyFragment :
    BaseFragment<FragmentOnboardingCurrencyBinding>(R.layout.fragment_onboarding_currency),
    OnboardingListener {

    override fun skipButtonOnClickListener(view: View) {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
    }
}