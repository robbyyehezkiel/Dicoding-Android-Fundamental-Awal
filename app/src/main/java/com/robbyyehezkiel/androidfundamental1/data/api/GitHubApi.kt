package com.robbyyehezkiel.androidfundamental1.data.api

import com.robbyyehezkiel.androidfundamental1.data.model.User
import com.robbyyehezkiel.androidfundamental1.data.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): UsersResponse

    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") username: String): User

    @GET("users/{username}/followers")
    suspend fun getUserFollowers(@Path("username") username: String): List<User>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(@Path("username") username: String): List<User>
}