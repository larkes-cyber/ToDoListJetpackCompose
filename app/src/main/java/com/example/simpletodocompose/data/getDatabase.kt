package com.example.simpletodocompose.data

import android.content.Context
import androidx.room.Room

fun getDatabase(context: Context):AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,"goals_database"
    )
        .fallbackToDestructiveMigration()
        .build()
}