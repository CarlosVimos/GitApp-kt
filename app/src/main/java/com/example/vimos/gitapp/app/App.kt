package com.example.vimos.gitapp.app

import android.app.Application
import android.content.Context

/**
 * Created by Vimos on 30/06/2018.
 */
class App : Application() {


    companion object Factory {


        fun get(context: Context): App = context.applicationContext as App


        fun getApplicationComponent(context: Context): ApplicationComponent =
                (context.applicationContext as App).applicationComponent
    }


    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
             //   .applicationModule(ApplicationModule(this))
                .build()
    }
}