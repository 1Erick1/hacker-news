package com.example.hackernews.features.posts.domain.repository

import com.example.hackernews.features.posts.domain.model.PostEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface PostsRepository {
    fun getPosts(): Single<List<PostEntity>>
    fun hidePost(id: Long): Completable
}