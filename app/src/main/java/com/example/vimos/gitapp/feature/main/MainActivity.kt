package com.example.vimos.gitapp.feature.main

import android.os.Bundle
import android.util.Log
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.SearchUserProvider
import com.example.vimos.gitapp.feature.base.BaseActivity
import com.example.vimos.gitapp.feature.main.search.SearchFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity() {


    private val searchFragment = SearchFragment.newInstance()

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getLayoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            getReplaceFragmentTransaction(R.id.fragmentContainer, searchFragment, SearchFragment.TAG).commit()
        }

        val repository = SearchUserProvider.provideSearchUser()

        compositeDisposable.add(
                repository.searchUsers("Carlos")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            Log.e("Result", "There are ${result.items.size} Carlos users")
                        }, { error ->
                            error.printStackTrace()
                        })
        )

    }
}
