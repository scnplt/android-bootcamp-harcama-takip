package dev.sertan.android.harcamatakip.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.worker.ExchangeRateWorker

class OnboardingActivity : AppCompatActivity(R.layout.activity_onboarding) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ExchangeRateWorker.setup(this)
    }
}