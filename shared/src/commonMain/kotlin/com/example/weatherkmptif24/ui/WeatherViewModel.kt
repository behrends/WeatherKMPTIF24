package com.example.weatherkmptif24.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherkmptif24.data.ApiWeatherRepository
import com.example.weatherkmptif24.data.WeatherRepository
import com.example.weatherkmptif24.model.City
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository = ApiWeatherRepository(),
) : ViewModel() {
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun loadWeather(city: City) {
        _uiState.value = WeatherUiState.Loading
        viewModelScope.launch {
            _uiState.value = try {
                WeatherUiState.Success(city, repository.getCurrentWeather(city))
            } catch (e: CancellationException) {
                throw e // Abbruch der Coroutine nicht als Fehler behandeln
            } catch (e: Exception) {
                WeatherUiState.Error(e.message ?: "Unbekannter Fehler")
            }
        }
    }
}
