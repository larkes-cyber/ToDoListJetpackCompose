package com.example.simpletodocompose.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.simpletodocompose.data.entity.EntityTask

@Dao
interface TasksDao {

    @Insert
    suspend fun insertTask(entityTask:EntityTask)

    @Query("SELECT * FROM EntityTask WHERE date = :day")
    suspend fun getTasks(day:String):List<EntityTask>

}