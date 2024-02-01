package com.robbyyehezkiel.androidfundamental1.data.model

data class User(
    val login: String,
    val avatar_url: String,
    val name: String,
    val followers: Int,
    val following: Int
)