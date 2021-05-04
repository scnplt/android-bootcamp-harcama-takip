package dev.sertan.android.harcamatakip.service.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.sertan.android.harcamatakip.service.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(@ApplicationContext context: Context) {
    private val valueClass = User::class.java

    private val key = valueClass.name

    private val defaultValue = valueClass.newInstance()

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { sp, key ->
        if (key == this.key) {
            val json = sp.getString(key, toJson(defaultValue))!!
            val data = fromJson(json)
            _user.postValue(data)
        }
    }

    private val sharedPreferences = context
        .getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        .apply { registerOnSharedPreferenceChangeListener(listener) }

    private val _user = MutableLiveData(getDataFromSharedPref())
    val user: LiveData<User> get() = _user

    fun updateUser(user: User) = sharedPreferences.edit()
        .putString(key, toJson(user))
        .apply()

    private fun getDataFromSharedPref(): User =
        fromJson(sharedPreferences.getString(key, toJson(defaultValue))!!)

    private fun toJson(data: User): String = Gson().toJson(data)

    private fun fromJson(json: String): User = Gson().fromJson(json, valueClass)
}