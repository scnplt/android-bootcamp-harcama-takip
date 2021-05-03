package dev.sertan.android.harcamatakip.service.repository

import dev.sertan.android.harcamatakip.service.model.User
import dev.sertan.android.harcamatakip.service.sharedpreferences.UserSharedPref
import javax.inject.Inject

class UserRepository @Inject constructor(userSharedPref: UserSharedPref) {
    val user = userSharedPref.data
    val updateUser = { user: User -> userSharedPref.putData(user) }
}