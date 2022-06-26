package com.github.nikokann

import android.content.Context
import androidx.room.Room
import com.github.nikokann.model.todo.TodoDAO
import com.github.nikokann.model.todo.TodoDatabase
import com.github.nikokann.repository.todo.TodoRepositoryImpl
import com.github.nikokann.repository.todo.Todorepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(
       @ApplicationContext context: Context
    ): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
             "todo.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTodoDAO(db: TodoDatabase): TodoDAO {
        return db.todoDAO()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ToDoRepositoryModule {

    @Singleton
    @Binds
    abstract  fun bindToDoRepository(
        impl: TodoRepositoryImpl
    ): Todorepository
}