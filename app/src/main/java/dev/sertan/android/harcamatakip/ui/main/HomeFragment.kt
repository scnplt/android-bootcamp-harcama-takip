package dev.sertan.android.harcamatakip.ui.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentHomeBinding
import dev.sertan.android.harcamatakip.ui.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewDataBinding(): FragmentHomeBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, null, false)
}