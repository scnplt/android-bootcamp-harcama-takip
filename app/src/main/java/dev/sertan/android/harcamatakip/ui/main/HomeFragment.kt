package dev.sertan.android.harcamatakip.ui.main

import androidx.databinding.DataBindingUtil
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentHomeBinding
import dev.sertan.android.harcamatakip.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewDataBinding(): FragmentHomeBinding =
        DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, null, false)
}