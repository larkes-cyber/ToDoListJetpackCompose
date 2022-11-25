package com.example.simpletodocompose.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.simpletodocompose.data.dao.TasksDao
import com.example.simpletodocompose.data.getDatabase
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.model.toEntityTask
import com.example.simpletodocompose.model.toTask
import com.example.simpletodocompose.viewmodel.MainActivityState

class MainActivityViewModel(
    private val context: Context
) :ViewModel() {
    private val tasksDao:TasksDao = getDatabase(context).tasksDao()

    private val _tasksState = mutableStateOf(MainActivityState())
    val state = _tasksState

    suspend fun insertTask(task: Task){
        tasksDao.insertTask(task.toEntityTask())
    }

    suspend fun getTasks(date:String){
        _tasksState.value = MainActivityState(isLoading = true)
        try {
            val data = tasksDao.getTasks(date)
            _tasksState.value = MainActivityState(isLoading = false, tasks = if(data != null)data.map { it.toTask()} else ArrayList())
        }catch (e:Exception){
            _tasksState.value = MainActivityState(isLoading = false, error = e.toString())
        }
    }

    suspend fun toCompletedTask(task:Task){
        task.status = true
        tasksDao.updateTask(task)
    }


}