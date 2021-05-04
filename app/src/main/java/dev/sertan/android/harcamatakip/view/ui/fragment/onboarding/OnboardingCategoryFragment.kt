package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCategoryBinding

class OnboardingCategoryFragment : Fragment(R.layout.fragment_onboarding_category) {
    private var _binding: FragmentOnboardingCategoryBinding? = null
    private val binding get() = _binding!!

    private val skipBtnOnClickListener = { _: View ->
        val action = OnboardingCategoryFragmentDirections
            .actionOnboardingCategoryFragmentToOnboardingCurrencyFragment()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip.setOnClickListener(skipBtnOnClickListener)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}