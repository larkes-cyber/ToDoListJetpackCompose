package com.example.simpletodocompose.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.view.componets.*
import com.example.simpletodocompose.view.theme.*
import com.example.simpletodocompose.viewmodel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.sql.StatementEvent
import kotlin.coroutines.CoroutineContext

class MainActivity : ComponentActivity(), CoroutineScope {

    lateinit var viewModel:MainActivityViewModel

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
    private fun toAddTask(task:Task){
        launch {
            viewModel.insertTask(task)
        }
    }
    private fun toUploadTasks(date:String){
        launch {
            viewModel.getTasks(date)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        job = Job()
        viewModel = MainActivityViewModel(applicationContext)
        val activityState = viewModel.state

        toUploadTasks("12.02.2002")

        setContent {
            SimpleToDoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MainBackgroundColor,

                ) {

                    val showFromState = remember {
                        mutableStateOf(false)
                    }

                    val closeFormState = remember {
                        mutableStateOf(false)
                    }



                    Box(modifier = Modifier.fillMaxSize()){

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxHeight()

                        ) {
                            //header: date and count of tasks
                            HeaderComponent(date = "12.02.2002", countOfCompleted = 5, countOfIncompleted = 5)

                            if(!activityState.value.isLoading && activityState.value.error.isEmpty()){
                                //list of incompleted tasks
                                TasksListComponent(title = "Incompleted", list = activityState.value.tasks!!.filter { !it.status })
                                //list of completed tasks
                                TasksListComponent(title = "Completed", list = activityState.value.tasks!!.filter { it.status })
                            }
                        }
                        //button to add task
                        FloatingButton(state = showFromState, closeState = closeFormState)
                        //form to bundle task
                        if(showFromState.value){
                            Form(showFromState, toAdd = ::toAddTask, closeState = closeFormState, date = "12.02.2002", toUploadTasks = ::toUploadTasks)
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
