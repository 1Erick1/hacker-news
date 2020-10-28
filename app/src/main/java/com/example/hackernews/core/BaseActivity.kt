package com.example.hackernews.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    abstract fun layout(): Int

    abstract fun setupViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        setupViewModel()
    }

    fun showToast(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}