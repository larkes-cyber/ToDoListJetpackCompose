package com.example.simpletodocompose.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.model.Task
import com.example.simpletodocompose.ui.theme.*


@Composable
fun IncompletedItem(task:Task){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
    ) {
        Card(modifier = Modifier
            .height(24.dp)
            .width(24.dp),
            shape = RoundedCornerShape(6.dp),
            backgroundColor = CheckBoxColor,
            border = BorderStroke(2.dp, BorderColorChecker)
        ){
        }
        Column(modifier = Modifier
            .padding(start = 16.dp)
        ) {
            Text(
                text = task.title,
                color = TitleColor,
                style = TextStyle(
                    fontSize = 18.sp
                ),
                fontFamily = inrel,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${task.icon} ${task.subtitle}",
                color = SubTitleColor,
                style = TextStyle(
                    fontSize = 14.sp
                ),
                fontFamily = inrel,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}