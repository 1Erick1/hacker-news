package com.example.hackernews.features.posts.data.datasources.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deleted")
data class DeletedDto(
    @PrimaryKey val id: Long
)