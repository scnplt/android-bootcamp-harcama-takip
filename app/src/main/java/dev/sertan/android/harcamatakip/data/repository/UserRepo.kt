package dev.sertan.android.harcamatakip.data.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.sharedpreferences.BaseSharedPref
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(private val sharedPref: BaseSharedPref<User>) {
    val user: LiveData<User> get() = sharedPref.data

    fun updateUser(user: User) = sharedPref.updateData(user)
}
