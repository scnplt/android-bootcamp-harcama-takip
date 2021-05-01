package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCategoryBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class OnboardingCategoryFragment : BaseFragment<FragmentOnboardingCategoryBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.skip.setOnClickListener {
            val action = OnboardingCategoryFragmentDirections.actionOnboardingSecondFragmentToOnboardingThirdFragment()
            findNavController().navigate(action)
        }
    }

    override fun getViewDataBinding(): FragmentOnboardingCategoryBinding = FragmentOnboardingCategoryBinding.inflate(layoutInflater)
}