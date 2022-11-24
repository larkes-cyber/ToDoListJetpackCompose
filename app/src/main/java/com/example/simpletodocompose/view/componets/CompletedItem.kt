package com.example.simpletodocompose.view.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodocompose.R
import com.example.simpletodocompose.model.Task

import com.example.simpletodocompose.view.theme.BorderColorChecker
import com.example.simpletodocompose.view.theme.CheckBoxColor
import com.example.simpletodocompose.view.theme.SubTitleColor
import com.example.simpletodocompose.view.theme.inrel


@Composable
fun CompletedItem(task:Task){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Box() {
            Card(modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                ,
                shape = RoundedCornerShape(6.dp),
                backgroundColor = CheckBoxColor,
                border = BorderStroke(2.dp, BorderColorChecker)
            ){
                Image(
                    painterResource(id = R.drawable.ic_baseline_check_24),
                    modifier = Modifier
                        .padding(3.dp)
                    ,
                    contentDescription = ""
                )
            }
        }
        Text(
            text = task.title,
            color = SubTitleColor,
            style = TextStyle(
                fontSize = 18.sp
            ),
            fontFamily = inrel,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
        )

    }
}