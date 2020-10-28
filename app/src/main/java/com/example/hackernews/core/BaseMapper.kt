package com.example.hackernews.core

abstract class BaseMapper<T,R> {

    abstract fun map(origin: T): R

    fun map(origin: List<T>): List<R> = origin.map { map(it) }
}