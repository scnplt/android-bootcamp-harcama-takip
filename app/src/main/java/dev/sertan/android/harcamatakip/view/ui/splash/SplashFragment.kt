package dev.sertan.android.harcamatakip.view.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.sertan.android.harcamatakip.R
import dev.sertan.android.harcamatakip.databinding.FragmentSplashBinding
import dev.sertan.android.harcamatakip.view.ui.BaseFragment
import dev.sertan.android.harcamatakip.viewmodel.SplashViewModel

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {
    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    companion object {
        const val SKIP_DURATION = 3000L
    }
}