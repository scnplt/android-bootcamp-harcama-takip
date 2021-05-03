package dev.sertan.android.harcamatakip.service.sharedpreferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.sertan.android.harcamatakip.service.model.User
import javax.inject.Inject

class UserSharedPref @Inject constructor(@ApplicationContext context: Context) :
    BaseSharedPreferences<User>(context, User::class.java)