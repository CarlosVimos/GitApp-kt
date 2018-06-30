package com.example.vimos.gitapp.feature.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.app.App
import com.example.vimos.gitapp.feature.BaseFragment
import com.example.vimos.gitapp.feature.base.BaseMvpFragment

/**
 * Created by Vimos on 30/06/2018.
 */

class SearchFragment : BaseMvpFragment<SearchFragmentView, SearchFragmentPresenter>(), SearchFragmentView {


    companion object {
        val TAG: String = SearchFragment::class.java.name


        fun newInstance() = SearchFragment()
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}