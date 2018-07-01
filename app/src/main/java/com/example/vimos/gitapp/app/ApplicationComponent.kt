package com.example.vimos.gitapp.app

import com.example.vimos.gitapp.feature.main.search.SearchFragmentComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Vimos on 30/06/2018.
 */

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {


    fun searchFragmentComponent(): SearchFragmentComponent

}
