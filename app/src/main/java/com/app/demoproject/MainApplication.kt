package com.app.demoproject

import android.app.Application
import com.app.demoproject.db.AppDatabase
import com.app.demoproject.session.Session

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        Session.sharedInstance(this)
        mDatabase = AppDatabase(this@MainApplication)
    }

    companion object {
        lateinit var mInstance: MainApplication
        lateinit var mDatabase: AppDatabase

        @Synchronized
        fun dbHelper(): AppDatabase = mDatabase

        @Synchronized
        fun getInstance(): MainApplication = mInstance

    }


}