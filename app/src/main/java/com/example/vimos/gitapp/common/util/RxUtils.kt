package com.example.vimos.gitapp.common.util

import io.reactivex.BackpressureStrategy
import io.reactivex.CompletableTransformer
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vimos on 30/06/2018.
 */


internal object RxUtils {

    fun <T> createFlowable(mode: BackpressureStrategy, source: (FlowableEmitter<T>) -> Unit): Flowable<T> {
        return Flowable.create(source, mode)
    }


    fun <T> applySingleIoSchedulers(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun applyCompletableIoSchedulers(): CompletableTransformer {
        return CompletableTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyFlowableIoSchedulers(): FlowableTransformer<T, T> {
        return FlowableTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyObservableIoSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyMaybeIoSchedulers(): MaybeTransformer<T, T> {
        return MaybeTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

}