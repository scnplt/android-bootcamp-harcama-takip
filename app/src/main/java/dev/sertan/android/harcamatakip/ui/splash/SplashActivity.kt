package dev.sertan.android.harcamatakip.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.ui.main.MainActivity
import dev.sertan.android.harcamatakip.ui.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    companion object {
        private const val SKIP_DURATION = 3000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable { skip() }
        handler.postDelayed(runnable, SKIP_DURATION)
    }

    private fun skip() {
        val key = application.packageName
        val sharedPref = getSharedPreferences(key, Context.MODE_PRIVATE)
        val isFirstOpening = !sharedPref.contains(key)

        val activityClass = if (isFirstOpening) {
            sharedPref.edit().putString(key, "").apply()
            OnboardingActivity::class.java
        } else MainActivity::class.java

        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
    }
}