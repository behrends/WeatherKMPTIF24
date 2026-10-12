package com.example.weatherkmptif24.data

import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.model.CurrentWeather
import com.example.weatherkmptif24.model.WeatherCondition

val fakeCities: List<City> = listOf(
    City(name = "Lörrach", latitude = 47.6156, longitude = 7.6614),
    City(name = "Freiburg", latitude = 47.9990, longitude = 7.8421),
    City(name = "Basel", latitude = 47.5596, longitude = 7.5886),
)

val fakeCurrentWeather: Map<String, CurrentWeather> = mapOf(
    "Lörrach" to CurrentWeather(
        temperature = 14.2,
        windSpeed = 8.5,
        condition = WeatherCondition.PARTLY_CLOUDY,
    ),
    "Freiburg" to CurrentWeather(
        temperature = 15.0,
        windSpeed = 6.1,
        condition = WeatherCondition.CLEAR,
    ),
    "Basel" to CurrentWeather(
        temperature = 13.6,
        windSpeed = 11.2,
        condition = WeatherCondition.RAIN,
    ),
)
