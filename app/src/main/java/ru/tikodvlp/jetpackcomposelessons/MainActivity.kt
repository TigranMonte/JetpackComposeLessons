package ru.tikodvlp.jetpackcomposelessons

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray)) {
                itemsIndexed(listOf(
                    ItemRowModel(R.drawable.logo_bw, "Karim", "Best player of 21-22 season, Ballon D'Or, " +
                            "best goalscorer, sniper, french international, five start player, so many trophies and still a lot to come " +
                            "KARIIIIIIIMMM BENZEEEMAAAAAA"),
                    ItemRowModel(R.drawable.logo_bw, "Luka", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Toni", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Dani", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Thibaut", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Isco", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Vini", "test"),
                    ItemRowModel(R.drawable.logo_bw, "Marco", "test"),
                    )
                ) { _, item ->
                    MyRow(item = item)
                }
            }
        }
    }
}

