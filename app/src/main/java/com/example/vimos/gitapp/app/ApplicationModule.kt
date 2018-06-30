package com.example.vimos.gitapp.app

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vimos on 30/06/2018.
 */

@Module
class ApplicationModule(private val application: Application) {


    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext


    @Provides
    @Singleton
    fun provideApplication() = application


    @Provides
    @Singleton
    fun provideResources(): Resources = application.resources


}