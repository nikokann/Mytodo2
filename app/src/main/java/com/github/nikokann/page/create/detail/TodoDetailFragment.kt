package com.github.nikokann.page.create.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.nikokann.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetailFragment: Fragment(R.layout.todo_detail_fragment) {
    private val vm: TodoDetailViewModel by viewModels()
}