package com.example.hackernews.features.posts.domain.model

import java.util.*

class PostEntity(
    val id: Long,
    val title: String,
    val author: String,
    val createdAt: Date,
    val url: String?
){
    override fun equals(other: Any?): Boolean {
        return other is PostEntity && other.id == this.id
    }
}