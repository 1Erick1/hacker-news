package com.example.hackernews.features.posts.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PostDao {
    @Query("SELECT * FROM post order by id desc")
    fun getPosts(): List<PostDto>

    @Insert
    fun savePosts(posts: List<PostDto>)

    @Query("DELETE FROM post")
    fun deleteAll()

}