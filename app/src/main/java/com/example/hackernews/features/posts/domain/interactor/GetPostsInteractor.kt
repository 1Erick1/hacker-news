package com.example.hackernews.features.posts.domain.interactor

import com.example.hackernews.features.posts.domain.model.PostEntity
import com.example.hackernews.features.posts.domain.repository.PostsRepository
import io.reactivex.Single

class GetPostsInteractor(private val postsRepository: PostsRepository) {

    fun execute(): Single<List<PostEntity>>{
        return postsRepository.getPosts()
    }
}