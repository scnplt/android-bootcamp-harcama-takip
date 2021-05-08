package dev.sertan.android.harcamatakip.service.repository

import androidx.lifecycle.LiveData
import dev.sertan.android.harcamatakip.service.model.User
import dev.sertan.android.harcamatakip.service.sharedpreferences.UserSharedPref
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userSharedPref: UserSharedPref) {
    val user: LiveData<User> get() = userSharedPref.user

    fun updateUser(user: User) = userSharedPref.updateUser(user)
}