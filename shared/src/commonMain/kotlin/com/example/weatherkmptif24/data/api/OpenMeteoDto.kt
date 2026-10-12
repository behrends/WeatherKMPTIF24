package com.example.weatherkmptif24.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// DTOs bilden die JSON-Antwort von Open-Meteo ab, nicht unser Datenmodell

@Serializable
data class ForecastResponse(
    val current: CurrentDto,
)

@Serializable
data class CurrentDto(
    @SerialName("temperature_2m") val temperature: Double,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("wind_speed_10m") val windSpeed: Double,
)
