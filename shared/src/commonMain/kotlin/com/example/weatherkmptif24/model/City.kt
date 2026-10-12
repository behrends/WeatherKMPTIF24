package com.example.weatherkmptif24.model

import kotlinx.serialization.Serializable

@Serializable // nötig, weil City Argument einer Route ist (siehe WeatherApp.kt)
data class City(
    val name: String,
    val latitude: Double,
    val longitude: Double,
)
