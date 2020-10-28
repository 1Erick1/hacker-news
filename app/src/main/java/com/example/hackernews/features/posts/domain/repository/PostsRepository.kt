package com.example.hackernews.features.posts.domain.repository

import com.example.hackernews.features.posts.domain.model.PostEntity
import io.reactivex.Single

interface PostsRepository {
    fun getNewsList(): Single<List<PostEntity>>
}