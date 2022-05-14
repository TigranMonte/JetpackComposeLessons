package ru.tikodvlp.jetpackcomposelessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth().fillMaxHeight(0.5f)) {
            Column( modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(0.5f).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Hello")
                Text(text = "Tiko")
                Text(text = "Monte")
            }
            Column(modifier = Modifier
                .background(Color.Magenta).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Hello")
                Text(text = "Tiko")
                Text(text = "Monte")
                }
            }
        }
    }
}