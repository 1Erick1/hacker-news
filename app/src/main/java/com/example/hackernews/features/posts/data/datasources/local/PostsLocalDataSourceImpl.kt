package com.example.hackernews.features.posts.data.datasources.local

import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import io.reactivex.Completable
import io.reactivex.Single

class PostsLocalDataSourceImpl : PostsLocalDataSource {

    override fun getNewsList(): Single<List<PostResponse>> {
        return Single.error(Throwable("Not implemented"))
    }

    override fun saveNews(): Completable {
        return Completable.create { it.onComplete() }
    }
}