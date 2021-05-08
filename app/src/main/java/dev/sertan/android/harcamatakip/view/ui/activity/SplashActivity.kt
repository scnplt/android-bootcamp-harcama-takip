package dev.sertan.android.harcamatakip.view.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dev.sertan.android.harcamatakip.R

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
        val activityClass = if (isFirstOpening()) OnboardingActivity::class.java
        else MainActivity::class.java

        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
    }

    private fun isFirstOpening(): Boolean {
        val key = application.packageName
        val sharedPref = getSharedPreferences(key, Context.MODE_PRIVATE)
        return !sharedPref.contains(key).also {
            if (!it) sharedPref.edit().putString(key, "").apply()
        }
    }
}