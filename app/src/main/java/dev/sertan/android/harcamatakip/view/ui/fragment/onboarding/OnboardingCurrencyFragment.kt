package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.view.ui.activity.MainActivity
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment

class OnboardingCurrencyFragment : BaseFragment<FragmentOnboardingCurrencyBinding>() {
    private val skipBtnOnClickListener = { _: View ->
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun getViewBinding(container: ViewGroup?): FragmentOnboardingCurrencyBinding =
        FragmentOnboardingCurrencyBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip.setOnClickListener(skipBtnOnClickListener)
    }
}