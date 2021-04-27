package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.sertan.android.harcamatakip.databinding.FragmentOnboarding3Binding
import dev.sertan.android.harcamatakip.ui.BaseFragment

class OnboardingThirdFragment : BaseFragment<FragmentOnboarding3Binding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.btnSkip.setOnClickListener {
            // TODO go to the main screen
            Toast.makeText(requireContext(), "Go to the main screen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getViewDataBinding(): FragmentOnboarding3Binding = FragmentOnboarding3Binding.inflate(layoutInflater)
}