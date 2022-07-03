package com.github.nikokann

import android.text.format.DateFormat.format
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.nikokann.databinding.TodoItemBinding
import com.github.nikokann.model.todo.Todo
import java.lang.String.format
import java.text.DateFormat

class TodoAdapter: ListAdapter<Todo, TodoAdapter.ViewHolder> (callbacks) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bindTo(todo)
    }

    class ViewHolder(
        private val binding:TodoItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(todo: Todo) {
            binding.titleText.text = todo.title
            binding.createText.text = android.text.format.DateFormat.format(
                "yyyy-MM-dd hh:mm:ss",
                todo.created
            )
        }

    }

    companion  object {
        private val callbacks = object: DiffUtil.ItemCallback<Todo>(){
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return  oldItem.title == newItem.title &&
                        oldItem.created == newItem.created
            }

        }
    }


}