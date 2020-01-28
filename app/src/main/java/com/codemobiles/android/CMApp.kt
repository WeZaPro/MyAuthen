package com.codemobiles.android

import android.app.Application
import android.content.ContextWrapper
import android.util.Log
import com.pixplicity.easyprefs.library.Prefs

class CMApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        Log.i("CMDEV","CMDev Initialization")

    }
}