package com.example.hackernews.features.posts.data.datasources.rest.mapper

import com.example.hackernews.core.BaseMapper
import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import com.example.hackernews.features.posts.domain.model.PostEntity
import java.util.*

class PostResponseMapper: BaseMapper<PostResponse, PostEntity>() {

    override fun map(origin: PostResponse): PostEntity {
        return PostEntity(
            id = origin.id,
            title = origin.title,
            author = origin.author,
            createdAt = Date(origin.createdAt * 1000),
            url = origin.url
        )
    }
}