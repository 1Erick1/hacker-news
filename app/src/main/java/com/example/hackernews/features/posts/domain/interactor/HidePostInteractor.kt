package com.example.hackernews.features.posts.domain.interactor

import com.example.hackernews.features.posts.domain.repository.PostsRepository
import io.reactivex.Completable

class HidePostInteractor(private val postsRepository: PostsRepository) {

    fun execute(id: Long): Completable{
        return postsRepository.hidePost(id)
    }
}