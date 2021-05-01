package dev.sertan.android.harcamatakip.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment
import dev.sertan.android.harcamatakip.ui.main.MainActivity

class OnboardingCurrencyFragment : BaseFragment<FragmentOnboardingCurrencyBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.skip.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun getViewDataBinding(): FragmentOnboardingCurrencyBinding = FragmentOnboardingCurrencyBinding.inflate(layoutInflater)
}