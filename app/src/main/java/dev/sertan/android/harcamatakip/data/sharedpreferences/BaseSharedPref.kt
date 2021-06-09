package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter

class BaseSharedPref<T>(
    context: Context,
    dataClass: Class<T>,
    private val adapter: JsonAdapter<T>
) {
    private val key: String = dataClass.name
    private val defaultValue: T = dataClass.newInstance()
    private val defaultValueJson: String = toJson(defaultValue)

    private val listener: SharedPreferences.OnSharedPreferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, mKey ->
            if (mKey == key) _data.postValue(getDataFromSharedPref())
        }

    private val sharedPref: SharedPreferences = context
        .getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        .apply { registerOnSharedPreferenceChangeListener(listener) }

    private val _data: MutableLiveData<T> = MutableLiveData(getDataFromSharedPref())
    val data: LiveData<T> get() = _data

    fun updateData(data: T) = sharedPref.edit().putString(key, toJson(data)).apply()

    private fun getDataFromSharedPref(): T = fromJson(sharedPref.getString(key, defaultValueJson)!!)

    private fun toJson(data: T): String = adapter.toJson(data)

    private fun fromJson(json: String): T = adapter.fromJson(json) ?: defaultValue
}
