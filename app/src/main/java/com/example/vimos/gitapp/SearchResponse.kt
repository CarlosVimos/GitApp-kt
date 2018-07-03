package com.example.vimos.gitapp

import com.google.gson.annotations.SerializedName

class SearchResponse {

    data class User(
            @SerializedName("login") val login: String,
            @SerializedName("id") val id: Long,
            @SerializedName("url") val url: String,
            @SerializedName("html_url") val htmlUrl: String,
            @SerializedName("followers_url") val followersUrl: String,
            @SerializedName("following_url") val followingUrl: String,
            @SerializedName("starred_url") val starredUrl: String,
            @SerializedName("gists_url") val gistsUrl: String,
            @SerializedName("type") val type: String,
            @SerializedName("score") val score: Double
    )

    data class UserList (
            @SerializedName("total_count") val total_count: Int,
            @SerializedName("incomplete_results") val incomplete_results: Boolean,
            @SerializedName("items") val items: List<User>)

}