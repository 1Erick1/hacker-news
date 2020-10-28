package com.example.hackernews.features.posts.presentation.mapper

import com.example.hackernews.core.BaseMapper
import com.example.hackernews.core.timeAgo
import com.example.hackernews.features.posts.domain.model.PostEntity
import com.example.hackernews.features.posts.presentation.model.PostModel

class PostModelMapper: BaseMapper<PostEntity,PostModel>() {
    override fun map(origin: PostEntity): PostModel {
        return PostModel(
            id = origin.id,
            title = origin.title,
            author = origin.author,
            createdAt = origin.createdAt.timeAgo(),
            url = origin.url
        )
    }
}