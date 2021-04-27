package dev.sertan.android.harcamatakip.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.sertan.android.harcamatakip.R

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goToMainScreen()
    }

    private fun goToMainScreen() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            // TODO Go to the main screen.
            Toast.makeText(this, "SplashScreen is finished.", Toast.LENGTH_SHORT).show()
        }
        handler.postDelayed(runnable, 3000)
    }
}