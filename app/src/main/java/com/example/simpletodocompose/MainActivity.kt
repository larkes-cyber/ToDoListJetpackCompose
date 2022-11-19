package com.example.simpletodocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.componets.HeaderComponent
import com.example.simpletodocompose.componets.IncompletedItem
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleToDoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MainBackgroundColor,

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        HeaderComponent(date = "March 9, 2020", countOfCompleted = 5, countOfIncompleted = 5)
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider(
                            Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(SubTitleColor)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Incomplete",
                            color = TitleColor,
                            style = TextStyle(
                                fontSize = 18.sp
                            ),
                            fontFamily = inrel,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal,
                            modifier = Modifier.fillMaxWidth()
                        )
                        IncompletedItem(task = Task("Upload 1099-R to TurboTax", icon = "\uD83D\uDCB0", subtitle = "Finance"))
                        IncompletedItem(task = Task("Upload 1099-R to TurboTax", icon = "\uD83D\uDCB0", subtitle = "Finance"))
                        IncompletedItem(task = Task("Upload 1099-R to TurboTax", icon = "\uD83D\uDCB0", subtitle = "Finance"))
                        IncompletedItem(task = Task("Upload 1099-R to TurboTax", icon = "\uD83D\uDCB0", subtitle = "Finance"))
                        IncompletedItem(task = Task("Upload 1099-R to TurboTax", icon = "\uD83D\uDCB0", subtitle = "Finance"))
                    }

                }
            }
        }
    }
}
