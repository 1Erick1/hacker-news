package com.example.hackernews.features.posts.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hackernews.features.posts.data.PostsRepositoryImpl
import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSource
import com.example.hackernews.features.posts.data.datasources.local.PostsLocalDataSourceImpl
import com.example.hackernews.features.posts.data.datasources.local.db.PostDatabase
import com.example.hackernews.features.posts.data.datasources.rest.PostsApi
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSource
import com.example.hackernews.features.posts.data.datasources.rest.PostsRestDataSourceImpl
import com.example.hackernews.features.posts.domain.interactor.GetPostsInteractor
import com.example.hackernews.features.posts.domain.interactor.HidePostInteractor
import com.example.hackernews.features.posts.domain.repository.PostsRepository
import com.example.hackernews.features.posts.presentation.viewmodel.PostsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val postsModule = module {
    single { get<Retrofit>().create(PostsApi::class.java) }
    single<PostsRestDataSource> { PostsRestDataSourceImpl(get()) }
    single { Room.databaseBuilder(androidContext(),PostDatabase::class.java,"hacker-news.db").build() }
    single<PostsLocalDataSource> { PostsLocalDataSourceImpl(get()) }
    single<PostsRepository> { PostsRepositoryImpl(get(),get(),androidContext()) }
    single { GetPostsInteractor(get()) }
    single { HidePostInteractor(get()) }
    viewModel { PostsViewModel(get(),get()) }
}