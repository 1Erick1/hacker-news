package com.example.hackernews.features.posts.data

import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSource
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSource
import com.example.hackernews.features.posts.data.datasources.rest.mapper.PostResponseMapper
import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import com.example.hackernews.features.posts.domain.model.PostEntity
import com.example.hackernews.features.posts.domain.repository.PostsRepository
import io.reactivex.Single

class PostsRepositoryImpl(
    private val restDataSource: PostsRestDataSource,
    private val localDataSource: PostsLocalDataSource
): PostsRepository {

    override fun getNewsList(): Single<List<PostEntity>> {
        val restObs: Single<List<PostResponse>> = restDataSource.getNewsList()
            .doOnSuccess {
                localDataSource.saveNews()
            }

        return Single
            .concat(
                restDataSource.getNewsList(),
                localDataSource.getNewsList()
            )
            .firstOrError()
            .map {
                PostResponseMapper().map(it)
            }
    }
}