package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.databinding.FragmentOnboarding2Binding
import dev.sertan.android.harcamatakip.ui.BaseFragment

class OnboardingSecondFragment : BaseFragment<FragmentOnboarding2Binding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.btnSkip.setOnClickListener {
            val action = OnboardingSecondFragmentDirections.actionOnboardingSecondFragmentToOnboardingThirdFragment()
            findNavController().navigate(action)
        }
    }

    override fun getViewDataBinding(): FragmentOnboarding2Binding = FragmentOnboarding2Binding.inflate(layoutInflater)
}