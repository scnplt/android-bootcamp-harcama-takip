package dev.sertan.android.harcamatakip.util

import android.app.Activity
import android.os.Build
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager

fun Activity.fullscreenMode(active: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val type = WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()
        window.insetsController?.apply {
            if (active) {
                hide(type)
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                show(type)
            }
        }
        return
    }

    val flag = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    if (active) window.addFlags(flag) else window.clearFlags(flag)
}
