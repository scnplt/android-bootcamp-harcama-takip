package dev.sertan.android.harcamatakip.view.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingBinding
import dev.sertan.android.harcamatakip.view.ui.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.OnboardingViewModel

@AndroidEntryPoint
class OnboardingFragment : BaseFragment<FragmentOnboardingBinding>(R.layout.fragment_onboarding) {
    private val viewModel: OnboardingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.viewPager.adapter = ViewPagerAdapter()
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
    }

    companion object {
        val PAGES_ID = listOf(
            R.layout.fragment_onboarding_welcome,
            R.layout.fragment_onboarding_category,
            R.layout.fragment_onboarding_currency
        )
    }

    private inner class ViewPagerAdapter : FragmentStateAdapter(requireActivity()) {
        override fun getItemCount(): Int = PAGES_ID.size
        override fun createFragment(position: Int): Fragment = Fragment(PAGES_ID[position])
    }
}