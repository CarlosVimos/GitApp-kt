package com.example.vimos.gitapp.feature.main.searchUser

import android.os.Bundle
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.feature.base.BaseActivity

class SearchUserActivity : BaseActivity() {


    private val searchFragment = SearchUserFragment.newInstance()

    override fun getLayoutId() = R.layout.activity_search_user


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            getReplaceFragmentTransaction(R.id.fragmentContainer, searchFragment, SearchUserFragment.TAG).commit()
        }


    }
}
