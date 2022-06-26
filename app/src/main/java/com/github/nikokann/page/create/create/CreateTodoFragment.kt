package com.github.nikokann.page.create.create

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.nikokann.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTodoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: CreateTodoViewModel by viewModels()
}