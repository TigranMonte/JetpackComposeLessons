package ru.tikodvlp.wheatherappcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ru.tikodvlp.wheatherappcompose.screens.MainCard
import ru.tikodvlp.wheatherappcompose.screens.TabLayout
import ru.tikodvlp.wheatherappcompose.ui.theme.JetpackComposeLessonsTheme


const val API_KEY = "7f8e782afb2743a79c3143406221810"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                getData("Madrid", this)
                Image(
                    painter = painterResource(id = R.drawable.wheather_bg),
                    contentDescription = "image1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            Log.d("MyLog", "Response: $response")
        },
        {
            Log.d("MyLog", "Volley Error: $it")
        }
    )
    queue.add(sRequest)
}
