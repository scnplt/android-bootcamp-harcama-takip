package dev.sertan.android.harcamatakip.view.ui.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingCurrencyBinding
import dev.sertan.android.harcamatakip.view.ui.activity.MainActivity

class OnboardingCurrencyFragment : Fragment(R.layout.fragment_onboarding_currency) {
    private var _binding: FragmentOnboardingCurrencyBinding? = null
    private val binding get() = _binding!!

    private val skipBtnOnClickListener = { _: View ->
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingCurrencyBinding.inflate(layoutInflater, container, false)
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