package com.example.hackernews.features.posts.presentation.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.hackernews.R
import com.example.hackernews.core.BaseActivity
import com.example.hackernews.features.posts.presentation.adapter.PostAdapter
import com.example.hackernews.features.posts.presentation.viewmodel.PostsViewModel
import io.sulek.ssml.SSMLLinearLayoutManager
import kotlinx.android.synthetic.main.activity_news_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListActivity: BaseActivity() {
    private val viewModel: PostsViewModel by viewModel()
    private lateinit var adapter : PostAdapter

    override fun layout() = R.layout.activity_news_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdapter()
        swipeRefresh.setOnRefreshListener {
            viewModel.getNews()
        }
        viewModel.getNews()
    }

    private fun setupAdapter() {
        adapter = PostAdapter(
            {
                adapter.removeItem(it)
                //TODO Store removed news ids
            },
            {
                if (it.isNullOrEmpty().not()){
                    startActivity(NewsDetailActivity.newInstance(this,it!!))
                }else{
                    showToast(getString(R.string.msg_missing_url))
                }
            })
        rvNews.layoutManager = SSMLLinearLayoutManager(this)
        rvNews.adapter = adapter
    }

    override fun setupViewModel() {
        viewModel.state.observe(this, Observer {
            when(it){
                is PostsViewModel.ViewState.LOADING->{
                    swipeRefresh.isRefreshing = true
                }
                is PostsViewModel.ViewState.SUCCESS->{
                    swipeRefresh.isRefreshing = false
                    adapter.setItems(it.posts)
                }
                is PostsViewModel.ViewState.ERROR->{
                    swipeRefresh.isRefreshing = false
                    showToast(getString(R.string.msg_network_error))
                }
            }
        })
    }
}