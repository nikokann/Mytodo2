package com.github.nikokann

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.nikokann.repository.todo.Todorepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: Todorepository
): ViewModel() {

    val todoList = repo.getAll().asLiveData()
}