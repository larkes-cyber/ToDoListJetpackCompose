package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.view.theme.*
import kotlin.reflect.KFunction1

@Composable
fun Form(
    state: MutableState<Boolean>,
    closeState:MutableState<Boolean>,
    date:String,
    toAdd: KFunction1<Task, Unit>,
    toUploadTasks:KFunction1<String,Unit>,

) {

    val textTaskState = remember {
        mutableStateOf("")
    }
    val textClassState = remember {
        mutableStateOf("")
    }
    val textIconState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(Modifier
            .height(2.dp)
            .background(BorderColorChecker)
            .fillMaxWidth()
        )
        Card(modifier = Modifier
            .fillMaxWidth(),
            backgroundColor = MainBackgroundColor,
            shape = RoundedCornerShape(6.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                    TextField(
                        value = textTaskState.value ,
                        onValueChange = {textTaskState.value = it},
                        label = { Text(text = "Enter your task") },
                        singleLine = true,
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                        ,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MainBackgroundColor,
                            textColor = TitleColor,
                            unfocusedIndicatorColor = OpacityColor,
                            unfocusedLabelColor = SubTitleColor
                        )
                    )
                    Divider(Modifier
                        .height(2.dp)
                        .background(BorderColorChecker))
                    Row {
                        TextField(
                            value = textClassState.value ,
                            onValueChange = {textClassState.value = it},
                            label = { Text(text = "Enter class") },
                            singleLine = true,
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(0.7f)
                            ,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MainBackgroundColor,
                                textColor = TitleColor,
                                unfocusedIndicatorColor = OpacityColor,
                                unfocusedLabelColor = SubTitleColor
                            )
                        )
                        Divider(modifier = Modifier
                            .height(50.dp)
                            .width(2.dp)
                            .background(BorderColorChecker))
                        TextField(
                            value = textIconState.value ,
                            onValueChange = {textIconState.value = it},
                            label = { Text(text = "Icon") },
                            singleLine = true,
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(0.9f)
                            ,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MainBackgroundColor,
                                textColor = TitleColor,
                                unfocusedIndicatorColor = OpacityColor,
                                unfocusedLabelColor = SubTitleColor
                            )
                        )
                    }
                }
                Divider(modifier = Modifier
                    .height(110.dp)
                    .width(2.dp)
                    .background(BorderColorChecker))

                IconButton(
                    onClick = {
                        state.value = false
                        toAdd(Task(title = textTaskState.value, icon = textIconState.value, subtitle = textClassState.value, date = date, status = false))
                    },
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                    Icon(
                        painterResource(id = com.example.simpletodocompose.R.drawable.ic_baseline_add_box_24),
                        contentDescription = "Refresh Button",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .background(FloatingColor)
                        ,
                        contentColorFor(backgroundColor = TitleColor)
                    )
                }
            }
        }
        Divider(Modifier
            .height(2.dp)
            .background(BorderColorChecker)
            .fillMaxWidth()
        )
    }

}