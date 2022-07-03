package com.github.nikokann.repository.todo

import com.github.nikokann.model.todo.Todo
import kotlinx.coroutines.flow.Flow

interface Todorepository {
    fun getAll(): Flow<List<Todo>>
    suspend fun create(title: String, detail: String)
}