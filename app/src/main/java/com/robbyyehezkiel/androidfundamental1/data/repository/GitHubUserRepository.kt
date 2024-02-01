package com.robbyyehezkiel.androidfundamental1.data.repository

import com.robbyyehezkiel.androidfundamental1.data.api.GitHubApi
import com.robbyyehezkiel.androidfundamental1.data.model.User
import com.robbyyehezkiel.androidfundamental1.data.model.UsersResponse

class GitHubUserRepository(private val gitHubApi: GitHubApi) : GitHubRepository {
    override suspend fun searchUsers(query: String): UsersResponse {
        return gitHubApi.searchUsers(query)
    }

    override suspend fun getUserDetail(username: String): User {
        return gitHubApi.getUserDetail(username)
    }

    override suspend fun getUserFollowers(username: String): List<User> {
        return gitHubApi.getUserFollowers(username)
    }

    override suspend fun getUserFollowing(username: String): List<User> {
        return gitHubApi.getUserFollowing(username)
    }

}