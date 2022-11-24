package com.example.simpletodocompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simpletodocompose.data.dao.TasksDao
import com.example.simpletodocompose.data.entity.EntityTask

@Database(entities = [EntityTask::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun tasksDao():TasksDao
}