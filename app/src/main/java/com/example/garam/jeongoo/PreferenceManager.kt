package com.example.garam.jeongoo

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager {

    val PREFERENCES_NAME = "rebuild_preference"
    val DEFAULT_VALUE_STRING = ""
    val DEFAULT_VALUE_INT = 0

    private fun getPreferences(context: Context): SharedPreferences? {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun setToken(context: Context, key: String, value: String) {
        val prefs = getPreferences(context)
        val editor = prefs?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    fun setId(context: Context?, key: String?, value: Int) {
        val prefs = getPreferences(context!!)
        val editor = prefs!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getToken(context: Context, key: String) : String? {
        val prefs = getPreferences(context)
        val value = prefs?.getString(key, DEFAULT_VALUE_STRING)

        return value
    }

    fun getId(context: Context?, key: String?): Int {
        val prefs = getPreferences(context!!)
        return prefs!!.getInt(key, DEFAULT_VALUE_INT)
    }

    fun clear(context: Context) {
        val prefs = getPreferences(context)
        val edit = prefs?.edit()
        edit?.clear()
        edit?.apply()
    }

}