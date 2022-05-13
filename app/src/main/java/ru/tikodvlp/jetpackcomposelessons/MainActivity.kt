package ru.tikodvlp.jetpackcomposelessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Text(text = "Hello")
                Text(text = "Tiko")
                Text(text = "Monte")
            }
        }
    }
}