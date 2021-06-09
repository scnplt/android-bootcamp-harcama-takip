package dev.sertan.android.harcamatakip.util

import android.os.Build
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.fragment.app.Fragment

fun Fragment.fullscreenMode(active: Boolean = true) {
    val window = requireActivity().window

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
        val flag = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        if (active) window.addFlags(flag) else window.clearFlags(flag)
        return
    }

    val type = WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()
    window.insetsController?.apply {
        if (active) {
            hide(type)
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            show(type)
        }
    }
}
