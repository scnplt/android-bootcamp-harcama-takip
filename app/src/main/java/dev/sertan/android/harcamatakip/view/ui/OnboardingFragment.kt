package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.sharedpreferences.OpeningStatusSharedPref
import dev.sertan.android.harcamatakip.databinding.FragmentOnboardingBinding
import dev.sertan.android.harcamatakip.view.ui.OnboardingFragment.Callback
import dev.sertan.android.harcamatakip.view.ui.base.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingFragment : BaseFragment<FragmentOnboardingBinding>(R.layout.fragment_onboarding) {
    @Inject
    lateinit var openingStatus: OpeningStatusSharedPref

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewPager.adapter = ViewPagerAdapter()
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == PAGES_ID.lastIndex) skip.visibility = View.VISIBLE
                }
            })
            callback = Callback {
                val action = OnboardingFragmentDirections.actionOnboardingToHome()
                findNavController().navigate(action).also { openingStatus.changeStatusToOpened() }
            }
            TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()
        }
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

    fun interface Callback {
        fun goToHomeFragment()
    }
}