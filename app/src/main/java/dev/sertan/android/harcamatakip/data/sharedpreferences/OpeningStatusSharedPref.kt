package dev.sertan.android.harcamatakip.data.sharedpreferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OpeningStatusSharedPref @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    fun isFirstOpening(): Boolean = sharedPref.getBoolean(KEY, true)

    fun changeStatusToOpened() = sharedPref.edit().putBoolean(KEY, false).apply()

    companion object {
        private const val KEY = "OpeningStatusSharedPref"
    }
}