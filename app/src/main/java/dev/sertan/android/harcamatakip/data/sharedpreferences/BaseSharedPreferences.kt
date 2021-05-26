package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson

class BaseSharedPreferences<T>(context: Context, private val dataClass: Class<T>) {
    private val key: String = dataClass.name
    private val defaultValue: T = dataClass.newInstance()

    private val listener: SharedPreferences.OnSharedPreferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sp, key ->
            if (key == this.key) {
                val json = sp.getString(key, toJson(defaultValue))!!
                val data = fromJson(json)
                _data.postValue(data)
            }
        }

    private val sharedPreferences: SharedPreferences = context
        .getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        .apply { registerOnSharedPreferenceChangeListener(listener) }

    private val _data: MutableLiveData<T> = MutableLiveData(getDataFromSharedPref())
    val data: LiveData<T> get() = _data

    fun updateData(data: T) = sharedPreferences.edit()
        .putString(key, toJson(data))
        .apply()

    private fun getDataFromSharedPref(): T =
        fromJson(sharedPreferences.getString(key, toJson(defaultValue))!!)

    private fun toJson(data: T): String = Gson().toJson(data)

    private fun fromJson(json: String): T = Gson().fromJson(json, dataClass)
}
