package com.example.hackernews.features.posts.data.datasources.rest

import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import io.reactivex.Single

class PostsRestDataSourceImpl(private val api : PostsApi): PostsRestDataSource {

    override fun getNewsList(): Single<List<PostResponse>> {
        return api.getNewsList()
            .map { it.posts }
    }
}