package com.example.hackernews.features.posts.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.hackernews.R
import com.example.hackernews.core.BaseActivity
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity: BaseActivity() {
    override fun layout() = R.layout.activity_news_detail

    companion object{
        const val KEY_NEWS_URL = "news_url"

        fun newInstance(context: Context, url: String): Intent =
            Intent(context,NewsDetailActivity::class.java)
                .apply {
                    putExtra(KEY_NEWS_URL,url)
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView.loadUrl(intent.getStringExtra(KEY_NEWS_URL))
    }

    override fun setupViewModel() {
    }
}