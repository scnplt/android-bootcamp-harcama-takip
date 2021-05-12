package dev.sertan.android.harcamatakip.view.binding.adapter

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2

object ViewPagerAdapters {
    @JvmStatic
    @BindingAdapter("page_change_callback")
    fun ViewPager2.setupPageChangeListener(callback: ViewPager2.OnPageChangeCallback) =
        registerOnPageChangeCallback(callback)
}