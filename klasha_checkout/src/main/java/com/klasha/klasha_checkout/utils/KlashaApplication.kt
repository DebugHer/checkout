package com.klasha.klasha_checkout.utils

import android.app.Application
import android.content.Context

class KlashaApplication : Application(){

    companion object{
        lateinit var appContext : Context
    }
    override fun onCreate() {
        super.onCreate()
        KlashaApplication.appContext = applicationContext
       // initPref()
    }

//    private fun initPref() {
//        Prefs.Builder()
//            .setContext(this)
//            .setMode(ContextWrapper.MODE_PRIVATE)
//            .setPrefsName(packageName)
//            .setUseDefaultSharedPreference(true)
//            .build()
//    }
}
