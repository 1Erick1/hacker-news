package com.example.hackernews.features.posts.di

import com.example.hackernews.features.posts.data.PostsRepositoryImpl
import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSource
import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSourceImpl
import com.example.hackernews.features.posts.data.datasources.rest.PostsApi
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSource
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSourceImpl
import com.example.hackernews.features.posts.domain.interactor.GetPostsInteractor
import com.example.hackernews.features.posts.domain.repository.PostsRepository
import com.example.hackernews.features.posts.presentation.viewmodel.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val postsModule = module {
    single { get<Retrofit>().create(PostsApi::class.java) }
    single<PostsRestDataSource> { PostsRestDataSourceImpl(get()) }
    single<PostsLocalDataSource> { PostsLocalDataSourceImpl() }
    single<PostsRepository> { PostsRepositoryImpl(get(),get()) }
    single { GetPostsInteractor(get()) }
    viewModel { PostsViewModel(get()) }
}