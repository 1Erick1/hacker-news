package com.example.hackernews.features.posts.data.datasources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hackernews.features.posts.data.datasources.local.dao.DeletedDao
import com.example.hackernews.features.posts.data.datasources.local.dao.PostDao
import com.example.hackernews.features.posts.data.datasources.local.dto.DeletedDto
import com.example.hackernews.features.posts.data.datasources.local.dto.PostDto

@Database(entities = [PostDto::class, DeletedDto::class], version = 1)
abstract class PostDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun deletedDao(): DeletedDao
}