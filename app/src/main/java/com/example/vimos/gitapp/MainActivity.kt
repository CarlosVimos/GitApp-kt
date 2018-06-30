package com.example.vimos.gitapp

import android.os.Bundle
import com.example.vimos.gitapp.feature.base.BaseActivity
import com.example.vimos.gitapp.feature.search.SearchFragment

class MainActivity : BaseActivity() {


    private val searchFragment = SearchFragment.newInstance()


    override fun getLayoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            getReplaceFragmentTransaction(R.id.fragmentContainer, searchFragment, SearchFragment.TAG).commit()
        }

    }
}
