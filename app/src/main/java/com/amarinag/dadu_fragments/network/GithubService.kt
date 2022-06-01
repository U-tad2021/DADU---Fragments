package com.amarinag.dadu_fragments.network

import com.amarinag.dadu_fragments.user.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/users")
    fun getUsers(): Call<List<User>>

    //@GET("/repositories")
    //fun getRepositories(): Call<List<Repository>>
}