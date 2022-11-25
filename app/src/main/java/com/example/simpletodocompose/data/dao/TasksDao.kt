package com.example.simpletodocompose.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.simpletodocompose.data.entity.EntityTask
import com.example.simpletodocompose.model.Task

@Dao
interface TasksDao {

    @Insert
    suspend fun insertTask(entityTask:EntityTask)

    @Query("SELECT * FROM EntityTask WHERE date = :day")
    suspend fun getTasks(day:String):List<EntityTask>

    @Update
    suspend fun updateTask(entityTask: EntityTask)

}