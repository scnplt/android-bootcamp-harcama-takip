package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.databinding.FragmentOnboarding1Binding
import dev.sertan.android.harcamatakip.ui.BaseFragment

class OnboardingFirstFragment : BaseFragment<FragmentOnboarding1Binding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.btnSkip.setOnClickListener {
            val action = OnboardingFirstFragmentDirections.actionOnboardingFirstFragmentToOnboardingSecondFragment()
            findNavController().navigate(action)
        }
    }

    override fun getViewDataBinding(): FragmentOnboarding1Binding = FragmentOnboarding1Binding.inflate(layoutInflater)
}