package com.haidev.pantaucorona.preferences

import android.content.Context

internal class AppPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "app_pref"
        private const val LOCATION = "location"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    fun setPref(value: AppModel) {
        val editor = preferences.edit()
        editor.putString(LOCATION, value.location)
        editor.apply()
    }

    fun getPref(): AppModel {
        val model = AppModel()
        model.location = preferences.getString(LOCATION, "")
        return model
    }
}