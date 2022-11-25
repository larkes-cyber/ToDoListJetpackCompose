package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.simpletodocompose.R
import com.example.simpletodocompose.view.theme.FloatingColor

@Composable
fun FloatingButton(state:MutableState<Boolean>,closeState:MutableState<Boolean>) {

    fun stateActions(){
        state.value = true
        closeState.value = false
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(end = 20.dp, bottom = 20.dp)
        ,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(onClick = { stateActions()},
            modifier = Modifier
                .height(56.dp)
                .width(56.dp),
            backgroundColor = FloatingColor,

            ) {
            Image(
                painterResource(id = R.drawable.ic_baseline_add_24),
                modifier = Modifier
                    .padding(3.dp)
                ,
                contentDescription = ""
            )
        }
    }
}