package dev.sertan.android.harcamatakip.viewmodel.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.service.model.Gender
import dev.sertan.android.harcamatakip.service.model.User
import dev.sertan.android.harcamatakip.service.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class ProfileSettingsViewModel
@Inject constructor(private val userRepo: UserRepository) : ViewModel() {
    val user: LiveData<User> get() = userRepo.user

    val name = MutableLiveData(user.value?.name ?: "")

    fun updateGender(gender: Gender) {
        user.value!!.gender = gender
    }

    fun save(view: View) {
        val user = user.value!!
        user.name = name.value!!.trim().lowercase()
        userRepo.updateUser(user)
        view.findNavController().popBackStack()
    }
}