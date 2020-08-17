package com.amol.jare.fittrapp.model

data class fittrResponse(
    val result: Result,
    val status: Int
)

data class Result(
    val data: Data
)

data class Data(
    val users: Users,
    val posts: List<Posts>
)

data class Users(
    val key: String,
    val value: String,
    val list: List<List<Any?>>
)

data class Posts(
    val key: String,
    val value: String,
    val list: List<List<Any?>>
)

data class List<T>(
    val post_id: Int,
    val id: Int,
    val slug: String,
    val user_id: Int,
    val description: String,
    val created_at: String,
    val group_id: Int,
    val profile_picture: String,
    val name: String,
    val corporate_tag: String,
    val image_urls: List<String>,
    val is_coach: Int,
    val is_trainer: Int
)