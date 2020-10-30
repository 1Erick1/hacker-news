package com.example.hackernews.features.posts.data.datasources.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostDto(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "createdAt") val createdAt: Long,
    @ColumnInfo(name = "url") val url: String?
){

    override fun equals(other: Any?): Boolean {
        return other is PostDto && other.id == this.id
    }
}