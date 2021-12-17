package com.example.bankingsystem.shared

import android.content.Context.MODE_PRIVATE
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.bankingsystem.model.Client
import com.google.gson.Gson


class SharedPreferencesHelper @SuppressLint("CommitPrefEdits") constructor(context: Context) {
    private val mShared: SharedPreferences =
        context.getSharedPreferences("Configs", MODE_PRIVATE)
    private val mEditor: SharedPreferences.Editor = mShared.edit()

    fun setStringSharedPreferences(key: String?, value: String?) {
        mEditor.putString(key, value)
        mEditor.commit()
    }

    fun getStringSharedPreferences(key: String?, defaultValue: String?): String? {
        return mShared.getString(key, defaultValue)
    }

    fun getStringSharedPreferences(key: String?): String? {
        return mShared.getString(key, null)
    }

    fun setObjectInSharedPreferences(key: String, saveObject: Any) {
        val prefsEditor: SharedPreferences.Editor = mShared.edit()
        val gson = Gson()
        val json: String = gson.toJson(saveObject)
        prefsEditor.putString(key, json)
        prefsEditor.apply()
    }

    fun getObject(key: String): Client? {
        val gson = Gson()
        val json: String = mShared.getString(key, "")!!
        return gson.fromJson(json, Client::class.java)
    }

    fun setIntSharedPreferences(key: String?, value: Int) {
        mEditor.putInt(key, value)
        mEditor.commit()
    }

    fun getIntSharedPreferences(key: String?, defaultValue: Int): Int {
        return mShared.getInt(key, defaultValue)
    }

    fun getIntSharedPreferences(key: String?): Int {
        return mShared.getInt(key, 0)
    }

    fun setBooleanSharedPreferences(key: String?, value: Boolean?) {
        mEditor.putBoolean(key, value!!)
        mEditor.commit()
    }

    fun getBooleanSharedPreferences(key: String?): Boolean {
        return mShared.getBoolean(key, false)
    }

    fun deleteSharedPreferences() {
        mEditor.clear()
        mEditor.commit()
    }

}
