package com.example.vimos.gitapp.feature.main.searchUser

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.vimos.gitapp.R
import com.example.vimos.gitapp.SearchResponse

class SearchUserAdapter(user: MutableList<SearchResponse.User>) : RecyclerView.Adapter<SearchUserHolder>() {


    private var users: MutableList<SearchResponse.User> = user

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchUserHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return SearchUserHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchUserHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun getDataSet(): MutableList<SearchResponse.User> {
        return users
    }

    fun setDataSet(users: MutableList<SearchResponse.User>) {
        this.users = users
    }

}
