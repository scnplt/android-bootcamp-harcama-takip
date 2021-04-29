package dev.sertan.android.harcamatakip.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.ui.BaseFragment
import dev.sertan.android.harcamatakip.ui.main.MainActivity

class OnboardingCurrencyFragment : BaseFragment<FragmentOnboardingCurrencyBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.btnSkip.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun getViewDataBinding(): FragmentOnboardingCurrencyBinding = FragmentOnboardingCurrencyBinding.inflate(layoutInflater)
}