package com.example.hackernews.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }
}