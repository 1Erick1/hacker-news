package com.example.hackernews

import android.app.Application
import com.example.hackernews.core.coreModule
import com.example.hackernews.features.posts.di.postsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HackerNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(coreModule + postsModule)
        }
    }
}