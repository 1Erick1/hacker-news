package com.example.hackernews.features.posts.presentation.model

data class PostModel(
    val id: Long,
    val title: String,
    val author: String,
    val url: String?,
    val createdAt: String
)