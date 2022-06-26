package com.github.nikokann.model.todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDAO():TodoDAO
}