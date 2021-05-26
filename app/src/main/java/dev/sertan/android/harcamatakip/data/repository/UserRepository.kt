package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val sharedPref: BaseSharedPreferences<User>) {
    val user: LiveData<User> get() = sharedPref.data

    fun updateUser(user: User) = sharedPref.updateData(user)
}
