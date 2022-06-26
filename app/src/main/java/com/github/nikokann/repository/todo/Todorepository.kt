package com.github.nikokann.repository.todo

interface Todorepository {
    suspend fun create(title: String, detail: String)
}