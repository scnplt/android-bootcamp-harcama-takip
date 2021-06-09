package dev.sertan.android.harcamatakip.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.sertan.android.harcamatakip.view.CategoryFragment
import dev.sertan.android.harcamatakip.view.CurrencyFragment
import dev.sertan.android.harcamatakip.view.WelcomeFragment

class OnboardingPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = PAGES.size

    override fun createFragment(position: Int): Fragment = PAGES[position].invoke()

    companion object {
        private val PAGES = listOf(
            { WelcomeFragment() },
            { CategoryFragment() },
            { CurrencyFragment() }
        )
    }
}
