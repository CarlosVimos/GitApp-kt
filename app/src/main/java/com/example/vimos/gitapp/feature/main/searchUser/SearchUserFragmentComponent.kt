package com.example.vimos.gitapp.feature.main.searchUser

import com.example.vimos.gitapp.common.di.FragmentScope
import dagger.Subcomponent

/**
 * Created by Vimos on 30/06/2018.
 */

@FragmentScope
@Subcomponent
interface SearchUserFragmentComponent {
    fun inject(searchUserFragment: SearchUserUserFragment)

    fun searchFragmentPresenter(): SearchUserFragmentPresenter
}