package com.example.weatherkmptif24.ui

import com.example.weatherkmptif24.model.WeatherCondition
import kotlin.math.roundToInt

fun WeatherCondition.emoji(): String = when (this) {
    WeatherCondition.CLEAR -> "☀️"
    WeatherCondition.PARTLY_CLOUDY -> "⛅"
    WeatherCondition.CLOUDY -> "☁️"
    WeatherCondition.FOG -> "🌫️"
    WeatherCondition.RAIN -> "🌧️"
    WeatherCondition.SNOW -> "❄️"
    WeatherCondition.THUNDERSTORM -> "⛈️"
}

fun WeatherCondition.label(): String = when (this) {
    WeatherCondition.CLEAR -> "Sonnig"
    WeatherCondition.PARTLY_CLOUDY -> "Teilweise bewölkt"
    WeatherCondition.CLOUDY -> "Bewölkt"
    WeatherCondition.FOG -> "Nebel"
    WeatherCondition.RAIN -> "Regen"
    WeatherCondition.SNOW -> "Schnee"
    WeatherCondition.THUNDERSTORM -> "Gewitter"
}

fun formatTemperature(celsius: Double, useCelsius: Boolean): String =
    if (useCelsius) {
        "${celsius.roundToInt()} °C"
    } else {
        "${(celsius * 9 / 5 + 32).roundToInt()} °F"
    }
