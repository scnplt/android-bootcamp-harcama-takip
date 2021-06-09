package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.sharedpreferences.OpeningStatusSharedPref
import dev.sertan.android.harcamatakip.view.OnboardingFragmentDirections
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel
@Inject constructor(private val openingStatusSharedPref: OpeningStatusSharedPref) : ViewModel() {

    fun goToHomeFragment(view: View) {
        view.isEnabled = false
        openingStatusSharedPref.changeToOpened()
        OnboardingFragmentDirections.onboardingToHome()
            .let { view.findNavController().navigate(it) }
    }
}
