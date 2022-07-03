package com.github.nikokann.page.create.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.nikokann.repository.todo.Todorepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CreateTodoViewModel @Inject constructor(
    private val repo: Todorepository
): ViewModel() {
    val errorMassege = MutableLiveData<String>()
    val done = MutableLiveData<Boolean>()
    fun save(title: String, detail: String) {
        //タイトルが空っぽだったらエラーメッセージを出す
        if (title.trim().isEmpty()) {
            errorMassege.value = "Please input title"
            return
        }
        //リポジトリ経由で実際の保存処理を行う
        viewModelScope.launch {
            try {
                repo.create(title, detail)
                done.value = true
            }catch (e:Exception){
                errorMassege.value = e.message
            }
        }

    }
}