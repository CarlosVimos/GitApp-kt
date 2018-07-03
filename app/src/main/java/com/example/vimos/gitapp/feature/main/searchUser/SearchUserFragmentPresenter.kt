package com.example.vimos.gitapp.feature.main.searchUser

import com.example.vimos.gitapp.SearchUserProvider
import com.example.vimos.gitapp.feature.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Vimos on 30/06/2018.
 */

class  SearchUserFragmentPresenter @Inject constructor() : BasePresenter<SearchUserFragmentView>() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val userProvider = SearchUserProvider.provideSearchUser()


    private val disposables = CompositeDisposable()
    private var disconnectSubscription: Disposable = Disposables.disposed()

    private var query: String = ""

    fun setQueryFilter(query: String) {

        Timber.i("Search query: $query")

        query.let {
            if (query.length > 2) {
                loadUsers(query)
            }
        }

    }

    fun loadUsers(username: String) {

        compositeDisposable.add(
                userProvider.searchUsers(username)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            Timber.i("There are ${result.items.size} $username users")
                        }, { error ->
                            error.printStackTrace()
                        })
        )

    }

    override fun detachView() {
        super.detachView()
        compositeDisposable.dispose()
        disposables.dispose()
        disconnectSubscription.dispose()
    }
}
