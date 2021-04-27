package dev.sertan.android.harcamatakip.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.ui.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goToMainScreen()
    }

    private fun goToMainScreen() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            // TODO Go to the main screen or onboarding screen.
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, 3000)
    }
}