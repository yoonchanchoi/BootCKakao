package com.example.bootckakao.util

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val pref: SharedPreferences) {

//    fun saveAllSeasonIdList(allSeasonIdList: MutableList<SeasonIdResult>){
//        val allSeasonIdListString: String = Gson().toJson(allSeasonIdList)
//        val editor: SharedPreferences.Editor = pref.edit()
//        editor.putString(Constants.PREF_KEY_ALL_SEASONID, allSeasonIdListString)
//        editor.apply()
//    }
//
//    fun getAllSeasonIdList(): MutableList<SeasonIdResult> {
//        var saveAllSeasonIdList = ArrayList<SeasonIdResult>()
//        pref.getString(Constants.PREF_KEY_ALL_SEASONID, "")?.let {
//            if (it.isNotEmpty()) {
//                saveAllSeasonIdList = Gson().fromJson(it, Array<SeasonIdResult>::class.java)
//                    .toMutableList() as ArrayList<SeasonIdResult>
//            }
//        }
//        return saveAllSeasonIdList
//    }

    fun putData(key: String, value: Any) {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
        }
    }

    private fun putString(key: String, value: String) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun putInt(key: String, value: Int) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    private fun putLong(key: String, value: Long) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    private fun putBoolean(key: String, value: Boolean) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    private fun putFloat(key: String, value: Float) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return pref.getString(key, "")
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun getLong(key: String): Long {
        return pref.getLong(key, 0)
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun getFloat(key: String): Float {
        return pref.getFloat(key, 0.0f)
    }

    fun removeKey(key: String) {
        pref.edit().remove(key).apply()
    }

    fun clear() {
        pref.edit().clear().apply()
    }
}