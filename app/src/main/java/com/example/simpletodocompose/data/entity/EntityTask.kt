package com.example.simpletodocompose.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntityTask(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val title:String,
    val icon:String,
    val subtitle:String,
    val date:String
)
