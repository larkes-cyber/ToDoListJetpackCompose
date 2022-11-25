package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.view.theme.SubTitleColor
import com.example.simpletodocompose.view.theme.inrel

@Composable
fun CountOfTasksComponent(
    countOfCompleted:Int,
    countOfIncompleted:Int
    ) {
    Column() {
        Text(
            text = "$countOfIncompleted incomplete, $countOfCompleted completed",
            color = SubTitleColor,
            style = TextStyle(
                fontSize = 14.sp
            ),
            fontFamily = inrel,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(SubTitleColor)
        )
    }
}