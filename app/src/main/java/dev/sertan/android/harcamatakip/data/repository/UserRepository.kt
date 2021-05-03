package dev.sertan.android.harcamatakip.data.repository

import dev.sertan.android.harcamatakip.data.model.User
import dev.sertan.android.harcamatakip.data.sharedpreferences.UserSharedPref
import javax.inject.Inject

class UserRepository @Inject constructor(userSharedPref: UserSharedPref) {
    val user = userSharedPref.data
    val updateUser = { user: User -> userSharedPref.putData(user) }
}