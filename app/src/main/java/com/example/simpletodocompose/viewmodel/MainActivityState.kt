package com.example.simpletodocompose.viewmodel

import com.example.simpletodocompose.model.Task

class MainActivityState(
    val isLoading: Boolean = true,
    val tasks:List<Task>? = null,
    val error: String = ""
)