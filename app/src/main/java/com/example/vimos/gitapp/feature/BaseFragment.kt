package com.example.vimos.gitapp.feature

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.common.extension.getColorCompat

/**
 * Created by Vimos on 29/06/2018.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int


    fun showSnackbarMessage(@StringRes resId: Int, @BaseTransientBottomBar.Duration duration: Int) {
        view?.let {
            val snackbar = Snackbar.make(it, resId, duration)
            val layout = snackbar.view as Snackbar.SnackbarLayout
            layout.setBackgroundColor(context.getColorCompat(R.color.colorPrimary))
            snackbar.show()
        }
    }
}