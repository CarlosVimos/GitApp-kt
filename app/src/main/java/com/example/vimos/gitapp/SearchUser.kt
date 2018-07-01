package com.example.vimos.gitapp

import io.reactivex.Observable

class SearchUser(val userService: UserService) {


    fun searchUsers(username: String): Observable<SearchResponse.UserList> {
        return userService.searchUsers(searchTerm = username)
    }

}