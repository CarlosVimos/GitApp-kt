package com.example.vimos.gitapp.feature.base

/**
 * Created by Vimos on 29/06/2018.
 */
abstract class BasePresenter<T : MvpView> : Presenter<T> {



    private var mvpView: T? = null


    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }


    override fun detachView() {
        mvpView = null
    }


    override fun getView() = mvpView
}