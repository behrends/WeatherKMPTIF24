package com.example.weatherkmptif24.data

import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.model.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(city: City): CurrentWeather
}
