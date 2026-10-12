package com.example.weatherkmptif24

import androidx.compose.runtime.Composable
import com.example.weatherkmptif24.ui.WeatherApp
import com.example.weatherkmptif24.ui.theme.WeatherAndroidTIF24Theme

@Composable
fun App() {
    WeatherAndroidTIF24Theme {
        WeatherApp()
    }
}
