package com.example.weatherkmptif24.ui

import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.model.CurrentWeather

sealed interface WeatherUiState {
    data object Loading : WeatherUiState
    data class Success(val city: City, val weather: CurrentWeather) : WeatherUiState
    data class Error(val message: String) : WeatherUiState
}
