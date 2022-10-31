package ru.tikodvlp.wheatherappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.tikodvlp.wheatherappcompose.R
import ru.tikodvlp.wheatherappcompose.data.WeatherModel
import ru.tikodvlp.wheatherappcompose.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = BlueLight,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "06 Jul 2022 10:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                        contentDescription = "image5",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(
                                top = 8.dp
                            )
                            .size(35.dp)
                    )
                }
                Text(
                    text = "Madrid",
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.White
                )
                Text(
                    text = "23°C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "image3",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "23°C/12°C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "image4",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(){
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
         modifier = Modifier
             .padding(
                 start = 5.dp, end = 5.dp
             )
             .clip(RoundedCornerShape(5.dp))
     ) {
         TabRow(
             selectedTabIndex = tabIndex,
             indicator = { pos ->
                         TabRowDefaults.Indicator(
                             Modifier.pagerTabIndicatorOffset(pagerState, pos)
                         )
             },
             backgroundColor = BlueLight,
             contentColor = Color.White
         ) {
             tabList.forEachIndexed{index, text ->
                 Tab(selected = false, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                 },
                    text = {
                            Text(text = text)
                    }
                 )
             }
         }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {
                index->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(
                    listOf(
                        WeatherModel(
                            "Madrid",
                            "10:00",
                            "25°C",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/night/116.png",
                            "",
                            "",
                            ""
                        ),
                        WeatherModel(
                            "Madrid",
                            "27/03/2022",
                            "",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/night/116.png",
                            "27°",
                            "22°",
                            "abdklf"
                        )
                    )
                ) {
                    _, item -> ListItem(item)
                }
            }
        }
    }
}