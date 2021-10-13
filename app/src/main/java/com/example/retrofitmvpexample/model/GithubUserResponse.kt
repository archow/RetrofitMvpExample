package com.example.retrofitmvpexample.model

data class GithubUserResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)