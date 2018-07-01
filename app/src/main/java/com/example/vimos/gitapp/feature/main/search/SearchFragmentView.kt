package com.example.vimos.gitapp.feature.main.search

import com.example.vimos.gitapp.feature.base.MvpView

/**
 * Created by Vimos on 30/06/2018.
 */

interface SearchFragmentView : MvpView {

    fun showUsers()
    fun setLoading(show: Boolean)
    fun itemClickedInfo()

}