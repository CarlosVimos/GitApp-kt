package com.example.vimos.gitapp.feature.main.searchUser

import com.example.vimos.gitapp.SearchResponse
import com.example.vimos.gitapp.feature.base.MvpView

/**
 * Created by Vimos on 30/06/2018.
 */

interface SearchUserFragmentView : MvpView {

    fun showUsers(list: MutableList<SearchResponse.User>, insert: Boolean)
    fun setLoading(show: Boolean)
    fun itemClickedInfo()

}