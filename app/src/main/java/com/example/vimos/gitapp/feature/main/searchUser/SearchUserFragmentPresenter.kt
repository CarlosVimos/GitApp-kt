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

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val userProvider = SearchUserProvider.provideSearchUser()

    private val disposables = CompositeDisposable()
    private var disconnectSubscription: Disposable = Disposables.disposed()

    private var onPage = 1
    private var username = ""

    fun setQueryFilter(query: String) {

        Timber.i("Search query: $query")

        query.let {
            username = query
            if (username.length > 2) {
                loadUsers(false)
            }
        }

    }

    fun loadUsers(insert: Boolean) {

        var nextPage = ""

        if (!insert) {
            onPage = 1
        } else {
            onPage++
        }

        nextPage = onPage.toString()
        getView()?.setLoading(true)

        compositeDisposable.add(
                userProvider.searchUsers(username, nextPage)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            getView()?.setLoading(false)
                            Timber.i("There are ${result.items.size} $username users")
                            getView()?.showUsers(result.items, true)
                        }, { error ->
                            error.printStackTrace()
                            getView()?.setLoading(false)
                        })
        )

    }

    fun loadMore() {
        loadUsers(true)
    }


    override fun detachView() {
        super.detachView()
        compositeDisposable.dispose()
        disposables.dispose()
        disconnectSubscription.dispose()
    }
}
