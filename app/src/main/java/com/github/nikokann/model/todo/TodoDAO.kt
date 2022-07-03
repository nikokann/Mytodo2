package com.github.nikokann.model.todo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDAO {
    @Query("select * from Todo where created < :startCreated order by created desc limit :limit")
    fun getWithCreated(startCreated: Long, limit: Int): Flow<List<Todo>>

    @Query("select * from Todo order by created desc")
    fun getAll(): Flow<List<Todo>>

    @Insert
    suspend fun create(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}