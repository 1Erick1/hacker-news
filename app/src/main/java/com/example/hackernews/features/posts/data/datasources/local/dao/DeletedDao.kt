package com.example.hackernews.features.posts.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hackernews.features.posts.data.datasources.local.dto.DeletedDto
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface DeletedDao {
    @Query("SELECT * FROM deleted")
    fun getDeleted(): List<DeletedDto>

    @Insert
    fun insertDeleted(id: DeletedDto): Completable
}