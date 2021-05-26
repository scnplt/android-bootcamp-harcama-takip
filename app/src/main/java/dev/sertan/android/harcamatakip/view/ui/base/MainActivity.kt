package dev.sertan.android.harcamatakip.view.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.util.fullscreenMode

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullscreenMode()
    }
}
