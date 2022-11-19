package com.example.simpletodocompose.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.ui.theme.SubTitleColor
import com.example.simpletodocompose.ui.theme.TitleColor
import com.example.simpletodocompose.ui.theme.inrel

@Composable
fun HeaderComponent(
    date:String,
    countOfCompleted:Int,
    countOfIncompleted:Int
){
    Column(
        Modifier
            .padding(top = 65.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = date,
            color = TitleColor,
            style = TextStyle(
                fontSize = 32.sp
            ),
            fontFamily = inrel,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        Text(
            text = "$countOfCompleted incomplete, $countOfIncompleted completed",
            color = SubTitleColor,
            style = TextStyle(
                fontSize = 14.sp
            ),
            fontFamily = inrel,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        )

    }
}