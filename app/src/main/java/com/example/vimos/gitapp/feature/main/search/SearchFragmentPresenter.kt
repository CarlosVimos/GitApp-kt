package com.example.vimos.gitapp.feature.main.search

import com.example.vimos.gitapp.feature.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import javax.inject.Inject

/**
 * Created by Vimos on 30/06/2018.
 */

class  SearchFragmentPresenter @Inject constructor() : BasePresenter<SearchFragmentView>() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()


    private val disposables = CompositeDisposable()
    private var disconnectOrdersSubscription: Disposable = Disposables.disposed()


    override fun detachView() {
        super.detachView()
        disposables.dispose()
        disconnectOrdersSubscription.dispose()
    }
}
