package com.example.hackernews.features.posts.data

import android.content.Context
import com.example.hackernews.core.isConnected
import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSource
import com.example.hackernews.features.posts.data.datasources.local.dto.DeletedDto
import com.example.hackernews.features.posts.data.datasources.local.mapper.PostDtoMapper
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSource
import com.example.hackernews.features.posts.data.datasources.rest.mapper.PostResponseDtoMapper
import com.example.hackernews.features.posts.data.datasources.rest.mapper.PostResponseMapper
import com.example.hackernews.features.posts.domain.model.PostEntity
import com.example.hackernews.features.posts.domain.repository.PostsRepository
import io.reactivex.Completable
import io.reactivex.Single
import java.util.*

class PostsRepositoryImpl(
    private val restDataSource: PostsRestDataSource,
    private val localDataSource: PostsLocalDataSource,
    private val context: Context
): PostsRepository {

    override fun getPosts(): Single<List<PostEntity>> {

        val obs: Single<List<PostEntity>> = if (context.isConnected){
            restDataSource.getPosts()
            .doOnSuccess {
                localDataSource.savePosts(PostResponseDtoMapper().map(it))
            }
                .map { PostResponseMapper().map(it) }
        }else{
            localDataSource.getPosts()
                .map { PostDtoMapper().map(it) }
        }

        return obs
            .flatMap {
                posts->
                localDataSource.getDeleted()
                    .map { it.map { PostEntity(it.id,"","", Date(),"") } }
                    .map{ deleted ->
                        posts.filterNot { deleted.contains(it) }
                    }
        }

    }


    override fun hidePost(id: Long): Completable {
        return localDataSource.addToHiddenPosts(DeletedDto(id))
    }
}