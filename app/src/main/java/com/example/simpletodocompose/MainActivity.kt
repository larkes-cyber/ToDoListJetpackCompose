package com.example.simpletodocompose

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.componets.CompletedItem
import com.example.simpletodocompose.componets.Form
import com.example.simpletodocompose.componets.HeaderComponent
import com.example.simpletodocompose.componets.IncompletedItem
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.ui.theme.*

class MainActivity : ComponentActivity() {

    private val userData = arrayListOf<Task>(
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance"),
        Task(title = "Submit 2019 tax return",icon = "\uD83D\uDCB0", subtitle = "Finance")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleToDoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MainBackgroundColor,

                ) {

                    val showFromState = remember {
                        mutableStateOf(false)
                    }

                    Box(modifier = Modifier.fillMaxSize()){

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxHeight()

                        ) {

                            Column(Modifier.fillMaxHeight(0.2f)) {
                                HeaderComponent(date = "March 9, 2020", countOfCompleted = 5, countOfIncompleted = 5)
                                Spacer(modifier = Modifier.height(16.dp))
                                Divider(
                                    Modifier
                                        .height(1.dp)
                                        .fillMaxWidth()
                                        .background(SubTitleColor)
                                )
                            }


                            Spacer(modifier = Modifier.height(16.dp))
                            Subtitle("Incomplete")
                            LazyColumn(Modifier.fillMaxHeight(0.6f)){
                                itemsIndexed(userData){index,task ->
                                    IncompletedItem(task = task)
                                }
                            }


                            Spacer(modifier = Modifier.height(23.dp))
                            Subtitle("Completed")
                            LazyColumn(Modifier.fillMaxHeight(0.9f)){
                                itemsIndexed(userData){index, task ->
                                    CompletedItem(task = task)
                                }
                            }
                        }





                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(end = 20.dp, bottom = 20.dp)
                            ,
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End
                        ) {
                            FloatingActionButton(onClick = {showFromState.value = true},
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


                            if(showFromState.value){
                                Form(showFromState)
                            }

                            Divider(Modifier
                                .height(2.dp)
                                .background(BorderColorChecker)
                                .fillMaxWidth()
                            )
                        }


                    }
                }
            }
        }
    }





    @Composable
    fun Subtitle(text:String){
        Text(
            text = text,
            color = TitleColor,
            style = TextStyle(
                fontSize = 18.sp
            ),
            fontFamily = inrel,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.fillMaxWidth()
        )
    }

}
