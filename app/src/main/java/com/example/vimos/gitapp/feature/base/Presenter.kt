package com.example.vimos.gitapp.feature.base

/**
 * Created by Vimos on 29/06/2018.
 */
interface Presenter<T : MvpView> {

    fun attachView(mvpView: T)

    fun detachView()

    fun getView(): T?
}