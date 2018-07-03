package com.example.vimos.gitapp

object SearchUserProvider {
    fun provideSearchUser(): SearchUser {
        return SearchUser(UserService.create())
    }
}