package com.example.vimos.gitapp.feature.base

import android.os.Bundle
import android.os.PersistableBundle

/**
 * Created by Vimos on 30/06/2018.
 */
abstract class BaseMvpActivity<T : MvpView, out P : Presenter<T>> : BaseActivity() {

    private lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        attachViewToPresenter()
    }


    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    @Suppress("UNCHECKED_CAST")
    private fun attachViewToPresenter() {
        presenter = retrievePresenter()
        presenter.attachView(this as T)
    }

    abstract fun retrievePresenter(): P


    fun getPresenter(): P = presenter

}