package com.example.vimos.gitapp.feature.base

import android.os.Bundle
import android.view.View

/**
 * Created by Vimos on 29/06/2018.
 */
abstract class BaseMvpFragment<T : MvpView, out P: Presenter<T>> : BaseFragment() {

    private lateinit var presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachViewToPresenter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    @Suppress("UNCHECKED_CAST")
    private fun attachViewToPresenter() {
        presenter = retrievePresenter()
        presenter.attachView(this as T)
    }



    abstract fun retrievePresenter(): P


    fun getPresenter(): P = presenter
}