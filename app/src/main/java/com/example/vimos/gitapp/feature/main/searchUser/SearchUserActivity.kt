package com.example.vimos.gitapp.feature.main.searchUser

import android.os.Bundle
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.feature.base.BaseActivity
import com.example.vimos.gitapp.feature.main.searchUser.SearchUserUserFragment

class SearchUserActivity : BaseActivity() {


    private val searchFragment = SearchUserUserFragment.newInstance()

    override fun getLayoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            getReplaceFragmentTransaction(R.id.fragmentContainer, searchFragment, SearchUserUserFragment.TAG).commit()
        }


    }
}
