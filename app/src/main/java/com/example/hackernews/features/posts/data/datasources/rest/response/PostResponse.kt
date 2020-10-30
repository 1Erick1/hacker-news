package com.example.hackernews.features.posts.data.datasources.rest.response

import com.squareup.moshi.Json

data class PostResponse(
    @field:Json(name = "objectID") val id: Long,
    @field:Json(name = "story_title") val title: String?,
    @field:Json(name = "title") val storyTitle: String?,
    @field:Json(name = "story_url") val url: String?,
    @field:Json(name = "author") val author: String,
    @field:Json(name = "created_at_i") val createdAt: Long
)