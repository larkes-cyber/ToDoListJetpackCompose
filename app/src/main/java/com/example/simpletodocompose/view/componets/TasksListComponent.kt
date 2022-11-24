package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpletodocompose.model.Task

@Composable
fun TasksListComponent(title:String, list:List<Task>) {

    Column() {
        Spacer(modifier = Modifier.height(16.dp))
        Subtitle(title)
        LazyColumn(Modifier.fillMaxHeight(0.6f)){
            itemsIndexed(list){index,task ->
                IncompletedItem(task = task)
            }
        }
    }

}