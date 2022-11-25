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
    private fun toUpdateTask(task:Task){
        launch {
            viewModel.toCompletedTask(task)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        job = Job()
        viewModel = MainActivityViewModel(applicationContext)
        val activityState = viewModel.state

        toUploadTasks(viewModel.getNowDate())

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

                            //main part(depends from data)
                            if(!activityState.value.isLoading && activityState.value.error.isEmpty()){

                                //tasks:completed, incompleted
                                val completedTasks = activityState.value.tasks!!.filter { it.status }
                                val incompletedTasks = activityState.value.tasks!!.filter { !it.status }

                                //header: date and count of tasks
                                HeaderComponent(date = viewModel.getNowDate(), countOfCompleted = completedTasks.size, countOfIncompleted = incompletedTasks.size)

                                //list of incompleted tasks
                                TasksListComponent(title = "Incompleted", list = incompletedTasks, toComplete = ::toUpdateTask)
                                //list of completed tasks
                                TasksListComponent(title = "Completed", list = completedTasks, toComplete = ::toUpdateTask)
                            }

                        }

                        //progress bar during data loading
                        if(activityState.value.isLoading){
                            Column(
                                modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator(Modifier
                                    .height(70.dp)
                                    .width(70.dp))
                            }

                        }


                        //button to add task
                        FloatingButton(state = showFromState, closeState = closeFormState)
                        //form to add task
                        if(showFromState.value){
                            Form(showFromState, toAdd = ::toAddTask, closeState = closeFormState, date = viewModel.getNowDate(), toUploadTasks = ::toUploadTasks)
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
