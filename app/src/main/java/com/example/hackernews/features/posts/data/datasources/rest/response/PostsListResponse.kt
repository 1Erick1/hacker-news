package com.example.hackernews.features.posts.data.datasources.rest.response

import com.squareup.moshi.Json

data class PostsListResponse(
    @field:Json(name = "hits") val posts: List<PostResponse>
)