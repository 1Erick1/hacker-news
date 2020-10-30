package com.example.hackernews.features.posts.data.datasources.rest.mapper

import com.example.hackernews.core.BaseMapper
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto
import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse

class PostResponseDtoMapper: BaseMapper<PostResponse,PostDto>() {
    override fun map(origin: PostResponse): PostDto {
        return PostDto(
            id = origin.id,
            title = origin.title?:origin.storyTitle?:"",
            author = origin.author,
            url = origin.url,
            createdAt = origin.createdAt
        )
    }
}