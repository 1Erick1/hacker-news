package com.example.hackernews.features.posts.data.datasources.local

import android.util.Log
import androidx.room.RoomDatabase
import com.example.hackernews.features.posts.data.datasources.local.db.PostDatabase
import com.example.hackernews.features.posts.data.datasources.local.dto.DeletedDto
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto
import com.example.hackernews.features.posts.data.datasources.rest.response.PostResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class PostsLocalDataSourceImpl(private val db: PostDatabase) : PostsLocalDataSource {

    override fun getPosts(): Single<List<PostDto>> {
        return Single.create {
            try {
                val posts = db.postDao().getPosts()
                if (posts.isEmpty()){
                    it.onError(Throwable("No posts found"))
                }else{
                    it.onSuccess(posts)
                }
                Log.d("PostsLocalDataSource","Posts got successfully from local db ${posts.size}")
            }catch (e: Exception){
                e.printStackTrace()
                it.onError(Throwable("Error getting post from local db"))
            }
        }
    }

    override fun getDeleted(): Single<List<DeletedDto>> {
        return Single.just(db.deletedDao().getDeleted())
    }

    override fun savePosts(posts: List<PostDto>) {
        try {
            db.postDao().deleteAll()
            db.postDao().savePosts(posts)
            Log.d("PostsLocalDataSource","Posts saved successfully ${posts.size}")
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun addToHiddenPosts(x: DeletedDto): Completable {
        return db.deletedDao().insertDeleted(x)
    }
}