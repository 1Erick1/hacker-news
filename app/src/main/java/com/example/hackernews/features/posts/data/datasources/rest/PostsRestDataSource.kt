package com.example.hackernews.features.posts.data.datasources.rest

import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import io.reactivex.Single

interface PostsRestDataSource {
    fun getPosts(): Single<List<PostResponse>>
}