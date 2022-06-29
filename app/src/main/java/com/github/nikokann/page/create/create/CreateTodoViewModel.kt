package com.github.nikokann.page.create.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.nikokann.repository.todo.Todorepository

class CreateTodoViewModel(
    private val repo: Todorepository
): ViewModel() {
    val errorMassege = MutableLiveData<String>()
    fun save(title: String, detail: String) {
        //タイトルが空っぽだったらエラーメッセージを出す
        if (title.trim().isEmpty()) {
            errorMassege.value = "Please input title"
            return
        }
        //リポジトリ経由で実際の保存処理を行う

    }
}