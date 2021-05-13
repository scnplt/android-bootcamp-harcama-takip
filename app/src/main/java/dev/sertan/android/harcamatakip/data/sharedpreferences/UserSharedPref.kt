package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import androidx.lifecycle.LiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.sertan.android.harcamatakip.data.model.User
import javax.inject.Inject

class UserSharedPref @Inject constructor(@ApplicationContext context: Context) :
    BaseSharedPreferences<User>(context, User::class.java) {

    val user: LiveData<User> get() = data

    fun updateUser(user: User) = updateData(user)
}