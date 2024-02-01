package com.robbyyehezkiel.androidfundamental1.data.repository


import com.robbyyehezkiel.androidfundamental1.data.model.User
import com.robbyyehezkiel.androidfundamental1.data.model.UsersResponse

interface GitHubRepository {
    suspend fun searchUsers(query: String): UsersResponse
    suspend fun getUserDetail(username: String): User
    suspend fun getUserFollowers(username: String): List<User>
    suspend fun getUserFollowing(username: String): List<User>
}