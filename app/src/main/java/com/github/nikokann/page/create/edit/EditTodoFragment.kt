package com.github.nikokann.page.create.edit

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.nikokann.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditTodoFragment: Fragment(R.layout.edit_todo_fragment) {
    private val vm: EditTodoViewModel by viewModels()
}