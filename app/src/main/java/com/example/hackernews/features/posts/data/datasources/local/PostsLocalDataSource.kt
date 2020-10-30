package com.example.hackernews.features.posts.data.datasources.local

import com.example.hackernews.features.posts.data.datasources.local.dto.DeletedDto
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto
import io.reactivex.Completable
import io.reactivex.Single

interface PostsLocalDataSource {
    fun getPosts(): Single<List<PostDto>>
    fun savePosts(posts: List<PostDto>)
    fun getDeleted(): Single<List<DeletedDto>>
    fun addToHiddenPosts(x: DeletedDto): Completable
}