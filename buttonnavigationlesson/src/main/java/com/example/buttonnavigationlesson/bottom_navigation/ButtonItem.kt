package com.example.buttonnavigationlesson.bottom_navigation

import com.example.buttonnavigationlesson.R

sealed class ButtonItem(val title: String, val iconId: Int, val route: String) {

    object Screen1: ButtonItem("Screen 1", R.drawable.icon, "screen_1")
    object Screen2: ButtonItem("Screen 2", R.drawable.icon1, "screen_2")
    object Screen3: ButtonItem("Screen 3", R.drawable.icon2, "screen_3")
    object Screen4: ButtonItem("Screen 4", R.drawable.icon3, "screen_4")
}
