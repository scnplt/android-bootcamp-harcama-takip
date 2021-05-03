package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCategoryBinding
import dev.sertan.android.harcamatakip.view.ui.fragment.BaseFragment

class OnboardingCategoryFragment : BaseFragment<FragmentOnboardingCategoryBinding>() {
    private val skipBtnOnClickListener = { _: View ->
        val action =
            OnboardingCategoryFragmentDirections.actionOnboardingSecondFragmentToOnboardingThirdFragment()
        findNavController().navigate(action)
    }

    override fun getViewBinding(container: ViewGroup?): FragmentOnboardingCategoryBinding =
        FragmentOnboardingCategoryBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip.setOnClickListener(skipBtnOnClickListener)
    }
}