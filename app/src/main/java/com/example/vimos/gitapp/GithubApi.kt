package com.example.vimos.gitapp

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class GithubApi {


//    val userService: UserService
//
//    init {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//
//        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(logging)
//
//        val gson = GsonBuilder().setLenient().create()
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build()
//                userService = retrofit.create<UserService>(UserService::class.java)
//    }
//
//    }

}