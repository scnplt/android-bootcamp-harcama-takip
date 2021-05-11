package dev.sertan.android.harcamatakip.viewmodel

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.sharedpreferences.OpeningStatusSharedPref
import dev.sertan.android.harcamatakip.view.ui.splash.SplashFragment
import dev.sertan.android.harcamatakip.view.ui.splash.SplashFragmentDirections
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sharedPref: OpeningStatusSharedPref) :
    ViewModel() {

    fun skip(view: View) {
        val runnable = Runnable {
            val action = if (sharedPref.isFirstOpening())
                SplashFragmentDirections.actionSplashToWelcome()
            else SplashFragmentDirections.actionSplashToHome()

            view.findNavController().navigate(action)
        }
        Handler(Looper.getMainLooper()).postDelayed(runnable, SplashFragment.SKIP_DURATION)
    }
}