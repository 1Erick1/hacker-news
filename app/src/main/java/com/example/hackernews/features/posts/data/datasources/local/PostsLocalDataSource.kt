package com.example.hackernews.features.posts.data.datasources.local

import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import io.reactivex.Completable
import io.reactivex.Single

interface PostsLocalDataSource {
    fun getNewsList(): Single<List<PostResponse>>
    fun saveNews(): Completable
}