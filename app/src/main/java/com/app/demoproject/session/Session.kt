package com.app.demoproject.session

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.app.demoproject.session.Keys

class Session(var context: Context) {

    private var mSharedPref: SharedPreferences? = context.getSharedPreferences(
        Keys.PREF_NAME,
        Context.MODE_PRIVATE
    )
    private var editor: SharedPreferences.Editor? = null


    companion object {

        lateinit var mPreference: Session

        fun sharedInstance(c: Context) {
            mPreference = Session(c)
        }

        fun getInstance(): Session? = mPreference

    }



    @SuppressLint("CommitPrefEdits")
    fun save(key: String?, `val`: String?) {
        editor = mSharedPref!!.edit()
        editor!!.putString(key, `val`)
        editor!!.apply()
    }

    @SuppressLint("CommitPrefEdits")
    fun save(key: String?, value: Boolean) {
        editor = mSharedPref!!.edit()
        editor!!.putBoolean(key, value)
        editor!!.apply()
    }

    @SuppressLint("CommitPrefEdits")
    fun save(key: String?, value: Int) {
        editor = mSharedPref!!.edit()
        editor!!.putInt(key, value)
        editor!!.apply()
    }

    fun getString(s1: String?): String? {
        return mSharedPref!!.getString(s1, "")
    }

    fun getInt(s1: String?): Int? {
        return mSharedPref!!.getInt(s1, 0)
    }

    fun userLogin(isLogin:Boolean) {
        save(Keys.USER_IS_LOGIN,isLogin)
    }

    fun isLogin(): Boolean {
        return mSharedPref!!.getBoolean(Keys.USER_IS_LOGIN, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun logout() {
        editor = mSharedPref!!.edit()
        editor!!.clear()
        editor!!.apply()
    }

}