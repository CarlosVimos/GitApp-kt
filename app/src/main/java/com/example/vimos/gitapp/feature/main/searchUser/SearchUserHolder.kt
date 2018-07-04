package com.example.vimos.gitapp.feature.main.searchUser

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.SearchResponse

class SearchUserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val userName by lazy {
        itemView.findViewById<TextView>(R.id.usernameTv)
    }

    fun bind(userSearched: SearchResponse.User) {
        userName.text = userSearched.login
    }

}