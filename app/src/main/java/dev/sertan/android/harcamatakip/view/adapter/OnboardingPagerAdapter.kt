package dev.sertan.android.harcamatakip.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.sertan.android.harcamatakip.view.ui.CategoryFragment
import dev.sertan.android.harcamatakip.view.ui.CurrencyFragment
import dev.sertan.android.harcamatakip.view.ui.WelcomeFragment

class OnboardingPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = PAGES.size

    override fun createFragment(position: Int): Fragment = PAGES[position]()

    companion object {
        private val PAGES = listOf(
            { WelcomeFragment() },
            { CategoryFragment() },
            { CurrencyFragment() }
        )
    }
}