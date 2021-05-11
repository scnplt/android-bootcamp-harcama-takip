package dev.sertan.android.harcamatakip.view.binding.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import dev.sertan.android.harcamatakip.view.binding.listener.RunListener

object ViewAdapters {
    @JvmStatic
    @BindingAdapter("run")
    fun View.run(listener: RunListener) = listener.run(this)
}