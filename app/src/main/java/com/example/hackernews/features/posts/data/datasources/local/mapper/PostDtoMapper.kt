package com.example.hackernews.features.posts.data.datasources.local.mapper

import com.example.hackernews.core.BaseMapper
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto
import com.example.hackernews.features.posts.domain.model.PostEntity
import java.util.*

class PostDtoMapper: BaseMapper<PostDto,PostEntity>() {

    override fun map(origin: PostDto): PostEntity {
        return PostEntity(
            id = origin.id,
            title = origin.title,
            author = origin.author,
            url = origin.url,
            createdAt = Date(origin.createdAt*1000L)
        )
    }
}