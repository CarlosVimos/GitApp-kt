package com.example.vimos.gitapp.feature.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by Vimos on 29/06/2018.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    fun getReplaceFragmentTransaction(containerViewId: Int, fragment: Fragment, tag: String): FragmentTransaction {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment, tag)
        return fragmentTransaction
    }




}

