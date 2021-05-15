package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.model.Gender
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val userRepo: UserRepository) : ViewModel() {

    val user: LiveData<User> get() = userRepo.user

    fun isGender(gender: Gender) = gender == user.value!!.gender

    fun updateGender(gender: Gender) {
        user.value!!.gender = gender
    }

    fun updateUser(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            user.value!!.apply { name = name.trim().lowercase() }.also { userRepo.updateUser(it) }
        }
        view.findNavController().popBackStack()
    }
}