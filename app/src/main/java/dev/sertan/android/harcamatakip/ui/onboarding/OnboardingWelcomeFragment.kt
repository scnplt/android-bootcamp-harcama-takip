package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingWelcomeBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class OnboardingWelcomeFragment : BaseFragment<FragmentOnboardingWelcomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.skip.setOnClickListener {
            val action = OnboardingWelcomeFragmentDirections.actionOnboardingFirstFragmentToOnboardingSecondFragment()
            findNavController().navigate(action)
        }
    }

    override fun getViewDataBinding(): FragmentOnboardingWelcomeBinding = FragmentOnboardingWelcomeBinding.inflate(layoutInflater)
}