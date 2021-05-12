package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.sharedpreferences.OpeningStatusSharedPref
import dev.sertan.android.harcamatakip.view.ui.fragment.OnboardingFragment
import dev.sertan.android.harcamatakip.view.ui.fragment.OnboardingFragmentDirections
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel
@Inject constructor(private val sharedPref: OpeningStatusSharedPref) : ViewModel() {

    private val _isLastPage = MutableLiveData(false)
    val isLastPage: LiveData<Boolean> get() = _isLastPage

    val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            _isLastPage.postValue(position == OnboardingFragment.PAGES_ID.lastIndex)
        }
    }

    fun goToHomeScreen(view: View) {
        val action = OnboardingFragmentDirections.actionOnboardingToHome()
        view.findNavController().navigate(action).also { sharedPref.changeStatusToOpened() }
    }
}