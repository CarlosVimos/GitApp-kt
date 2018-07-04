package com.example.vimos.gitapp.feature.main.searchUser

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.SearchResponse
import com.example.vimos.gitapp.app.App
import com.example.vimos.gitapp.feature.base.BaseMvpFragment
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search_user.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by Vimos on 30/06/2018.
 */

class SearchUserFragment : BaseMvpFragment<SearchUserFragmentView, SearchUserFragmentPresenter>(), SearchUserFragmentView,
        SwipeRefreshLayout.OnRefreshListener {

    companion object {
        val TAG: String = SearchUserFragment::class.java.name


        fun newInstance() = SearchUserFragment()
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var scrollListener: RecyclerViewScrollListener? = null
    var userAdapter: SearchUserAdapter? = null

    var load = true
    val listUser: MutableList<SearchResponse.User> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i("onViewCreated")

        swipeRefreshLayout.setOnRefreshListener(this)
        userListRecycler.layoutManager = LinearLayoutManager(context)
        userAdapter = SearchUserAdapter(listUser)
        userListRecycler.adapter = userAdapter

        compositeDisposable.add(
                RxTextView.textChanges(searchUser)
                        .map(CharSequence::toString)
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.computation())
                        .subscribe { query ->
                            getPresenter().setQueryFilter(query)
                            userAdapter?.getDataSet()?.clear()
                        }
        )

        userListRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    if (dy > 0) {
                        val manager = recyclerView?.layoutManager
                        val visibleItemCount = manager?.childCount
                        val totalItemCount = manager?.itemCount
                        val pastVisibleItems = (manager as LinearLayoutManager).findFirstVisibleItemPosition()

                        if (load) {
                            if ((visibleItemCount!! + pastVisibleItems) >= totalItemCount!!) {
                                load = false
                                onEndReached()

                            }
                        }
                    }
            }
        })

    }

    fun onEndReached() {
        getPresenter().loadMore()
    }

    fun setLoadScroll(load: Boolean) {
        this.load = load
    }




    override fun setLoading(show: Boolean) {
        swipeRefreshLayout.isRefreshing = show
    }

    override fun itemClickedInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUsers(list: MutableList<SearchResponse.User>, insert: Boolean) {

        if (insert) {
            userAdapter?.notifyDataSetChanged()
            userAdapter?.getDataSet()?.addAll(list)
            val insertStart = userAdapter!!.getDataSet().size
            val size = list.size
            userAdapter!!.notifyItemRangeInserted(insertStart, size)

            Timber.i("insert start: $insertStart and size is: $size")

        } else {
            userAdapter?.setDataSet(list)
            userAdapter?.notifyDataSetChanged()

        }

        scrollListener?.setLoading(true)
        setLoadScroll(true)
        Timber.i("Items in recycler: ${userListRecycler.adapter.itemCount}");

    }

    override fun onDestroyView() {
        super.onDestroyView()
        getPresenter().detachView()
    }


    override fun retrievePresenter() = App.getApplicationComponent(context).searchFragmentComponent().searchFragmentPresenter()

    override fun getLayoutId() = R.layout.fragment_search_user

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }



}