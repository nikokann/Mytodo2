package com.github.nikokann.repository.todo

import com.github.nikokann.model.todo.Todo
import com.github.nikokann.model.todo.TodoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor (
    private val dao:TodoDAO
    ): Todorepository {
    override suspend fun create(title: String, detail: String) {
        val now =System.currentTimeMillis()
        val todo = Todo(title = title,detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO){
            dao.create(todo)
        }

    }
}