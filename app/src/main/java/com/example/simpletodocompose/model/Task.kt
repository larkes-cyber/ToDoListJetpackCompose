package com.example.simpletodocompose.model

import com.example.simpletodocompose.data.entity.EntityTask

class Task(
    val title:String,
    val icon:String,
    val subtitle:String,
    val date:String,
    var status:Boolean,
    val id:Int? = null
)

fun Task.toEntityTask():EntityTask{
    return EntityTask(
        title = title,
        icon = icon,
        subtitle = subtitle,
        date = date,
        status = status,
        id = id

    )
}

fun EntityTask.toTask():Task{
    return Task(
        title = title,
        icon = icon,
        subtitle = subtitle,
        date = date,
        status = status,
        id = id
    )
}