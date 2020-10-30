package com.example.hackernews.features.posts.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackernews.core.BaseViewModel
import com.example.hackernews.features.posts.domain.interactor.GetPostsInteractor
import com.example.hackernews.features.posts.domain.interactor.HidePostInteractor
import com.example.hackernews.features.posts.presentation.mapper.PostModelMapper
import com.example.hackernews.features.posts.presentation.model.PostModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostsViewModel(
    private val getPostsInteractor: GetPostsInteractor,
    private val hidePostInteractor: HidePostInteractor
): BaseViewModel() {

    val state = MutableLiveData<ViewState>()

    fun getNews(){
        disposables.add(getPostsInteractor.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                state.value = ViewState.LOADING
            }
            .subscribe(
                {
                    state.value = ViewState.SUCCESS(PostModelMapper().map(it))
                },
                {
                    state.value = ViewState.ERROR
                    it.printStackTrace()
                }
            ))
    }

    fun hidePost(id: Long){
        disposables.add(hidePostInteractor.execute(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("PostsViewModel","Post hidden successfully")
                },
                {
                    it.printStackTrace()
                }
            ))
    }

    sealed class ViewState{
        object LOADING: ViewState()
        class SUCCESS(val posts: List<PostModel>): ViewState()
        object ERROR: ViewState()
    }
}