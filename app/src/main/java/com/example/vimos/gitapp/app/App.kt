package com.example.vimos.gitapp.app

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.StrictMode
import android.support.multidex.MultiDex
import com.example.vimos.gitapp.BuildConfig
import com.kirillr.strictmodehelper.StrictModeCompat
import timber.log.Timber

/**
 * Created by Vimos on 30/06/2018.
 */
class App : Application() {


    companion object Factory {


        fun get(context: Context): App = context.applicationContext as App


        fun getApplicationComponent(context: Context?): ApplicationComponent =
                (context?.applicationContext as App).applicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            setStrictMode()
        }
    }


    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().build()
    }

    private fun setStrictMode() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .detectUnbufferedIo()
                    .penaltyLog()
                    .build())

            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .detectUntaggedSockets()
                    .detectContentUriWithoutPermission()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())

        } else {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build())

            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
    }
}