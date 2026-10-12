package com.example.weatherkmptif24.model

enum class WeatherCondition { CLEAR, PARTLY_CLOUDY, CLOUDY, FOG, RAIN, SNOW, THUNDERSTORM }

data class CurrentWeather(
    val temperature: Double,
    val windSpeed: Double,
    val condition: WeatherCondition,
)
