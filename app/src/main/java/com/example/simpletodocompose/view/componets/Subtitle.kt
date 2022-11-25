package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.view.theme.TitleColor
import com.example.simpletodocompose.view.theme.inrel

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