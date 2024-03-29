package com.github.nikokann.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val _id: Int =0,
    val title: String,
    val detail: String,
    val created: Long,
    val modified: Long
)