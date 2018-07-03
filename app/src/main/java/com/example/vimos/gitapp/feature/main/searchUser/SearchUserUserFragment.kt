package com.example.vimos.gitapp.feature.main.searchUser

import android.os.Bundle
import android.view.View
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.app.App
import com.example.vimos.gitapp.feature.base.BaseMvpFragment
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by Vimos on 30/06/2018.
 */

class SearchUserUserFragment : BaseMvpFragment<SearchUserFragmentView, SearchUserFragmentPresenter>(), SearchUserFragmentView {


    companion object {
        val TAG: String = SearchUserUserFragment::class.java.name


        fun newInstance() = SearchUserUserFragment()
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Timber.i("onViewCreated")

        compositeDisposable.add(
                RxTextView.textChanges(searchUser)
                        .map(CharSequence::toString)
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.computation())
                        .subscribe { query ->
                            getPresenter().setQueryFilter(query)
                        }
        )


    }


    override fun showUsers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLoading(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun itemClickedInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrievePresenter() = App.getApplicationComponent(context).searchFragmentComponent().searchFragmentPresenter()

    override fun getLayoutId() = R.layout.fragment_search


}