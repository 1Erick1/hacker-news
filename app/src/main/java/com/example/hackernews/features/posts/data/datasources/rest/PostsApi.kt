package com.example.hackernews.features.posts.data.datasources.rest

import com.example.hackernews.features.posts.data.datasources.rest.response.PostsListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PostsApi {

    @GET("search_by_date?query=android")
    fun getNewsList(): Single<PostsListResponse>
}