package dev.sertan.android.harcamatakip.service.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson

abstract class BaseSharedPreferences<T>(context: Context, private val dataClass: Class<T>) {
    private val key = "${context.packageName}.${this::class.simpleName}"
    private val defaultData: T = dataClass.newInstance()

    private val sharedPref: SharedPreferences = context
        .getSharedPreferences(key, Context.MODE_PRIVATE)

    private val _data = MutableLiveData(defaultData)
    val data: LiveData<T>
        get() = _data

    init {
        setupListener()
        getData()
    }

    fun putData(data: T) =
        sharedPref.edit()
            .clear()
            .putString(key, toJSON(data))
            .commit()

    private fun getData() {
        val defaultJSON = toJSON(defaultData)
        val json = sharedPref.getString(key, defaultJSON)
        _data.postValue(fromJSON(json!!))
    }

    private fun setupListener() {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, _ ->
            getData()
        }
        sharedPref.registerOnSharedPreferenceChangeListener(listener)
    }

    private fun toJSON(data: T) = Gson().toJson(data)

    private fun fromJSON(json: String) = Gson().fromJson(json, dataClass)
}