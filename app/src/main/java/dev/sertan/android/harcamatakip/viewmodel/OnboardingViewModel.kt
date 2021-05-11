package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.sharedpreferences.OpeningStatusSharedPref
import dev.sertan.android.harcamatakip.view.ui.onboarding.OnboardingCategoryFragmentDirections
import dev.sertan.android.harcamatakip.view.ui.onboarding.OnboardingCurrencyFragmentDirections
import dev.sertan.android.harcamatakip.view.ui.onboarding.OnboardingWelcomeFragmentDirections
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val sharedPref: OpeningStatusSharedPref) :
    ViewModel() {

    fun goToHomeScreen(view: View) {
        val action = OnboardingCurrencyFragmentDirections.actionCurrencyToHome()
        view.findNavController().navigate(action)
            .also { sharedPref.changeStatusToOpened() }
    }

    fun goToCategoryScreen(view: View) {
        val action = OnboardingWelcomeFragmentDirections.actionWelcomeToCategory()
        view.findNavController().navigate(action)
    }

    fun goToCurrencyScreen(view: View) {
        val action = OnboardingCategoryFragmentDirections.actionCategoryToCurrency()
        view.findNavController().navigate(action)
    }
}