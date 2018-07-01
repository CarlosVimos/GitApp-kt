package com.example.vimos.gitapp.feature.main.search

import com.example.vimos.gitapp.common.di.FragmentScope
import dagger.Subcomponent

/**
 * Created by Vimos on 30/06/2018.
 */

@FragmentScope
@Subcomponent
interface SearchFragmentComponent {
    fun inject(searchFragment: SearchFragment)

    fun searchFragmentPresenter(): SearchFragmentPresenter
}