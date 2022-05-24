package ru.tikodvlp.wheatherappcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import ru.tikodvlp.wheatherappcompose.ui.theme.JetpackComposeLessonsTheme


const val API_KEY = "2affe497dfcb4d6aa58142449222305"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Moscow", this)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, context: Context) {
    val state = remember{
        mutableStateOf("Unknown")
    }
    Column (modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxHeight(0.5f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center) {
            Text(text = "Temp in $name = ${state.value} C")
        }
        Box(modifier = Modifier.fillMaxHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter) {
            Button(onClick = {
                getResult(name, state,context)
            }, modifier = Modifier.padding(5.dp).fillMaxWidth()
            ) {
                Text(text = "Refresh")
            }
        }
    }
}
private fun getResult(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.wheatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$city" +
            "&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET, url,
        {
            response ->
            val obj = JSONObject(response )
            state.value = obj.getJSONObject("current").getString("temp_c" )
        },
        {
            error ->
            Log.d("MyLog", "Error $error")
        }
    )
    queue.add(stringRequest)
}