package dev.sertan.android.harcamatakip.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sertan.android.harcamatakip.data.model.Gender
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
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