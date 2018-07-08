package com.example.vimos.gitapp.feature.main.searchUser

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.SearchResponse



class SearchUserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val username by lazy {
        itemView.findViewById<TextView>(R.id.usernameTv)
    }

    private val score by lazy {
        itemView.findViewById<TextView>(R.id.scoreTv)
    }

    private val avatar by lazy {
        itemView.findViewById<ImageView>(R.id.avatar)
    }

    fun bind(userSearched: SearchResponse.User) {
        username.text = userSearched.login
        score.text = userSearched.score.toString()

        Glide.with(itemView.context)
                .load(userSearched.avatarUrl)
                .into(avatar)


    }

}