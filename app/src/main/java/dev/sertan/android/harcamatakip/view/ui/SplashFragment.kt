package dev.sertan.android.harcamatakip.view.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.data.sharedpreferences.OpeningStatusSharedPref
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var openingStatus: OpeningStatusSharedPref

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Runnable {
            val action = if (openingStatus.isFirst()) SplashFragmentDirections.splashToOnboarding()
            else SplashFragmentDirections.splashToHome()
            findNavController().navigate(action)
        }.apply { Handler(Looper.getMainLooper()).postDelayed(this, SKIP_DURATION) }
    }

    companion object {
        const val SKIP_DURATION = 3000L
    }
}