package com.example.weatherkmptif24.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.weatherkmptif24.data.fakeCities
import com.example.weatherkmptif24.model.City
import kotlinx.serialization.Serializable

// Routen: jeder Screen ist ein Typ, Argumente sind Properties
@Serializable
data object CityList : NavKey

@Serializable
data class CityWeather(val city: City) : NavKey

@Composable
fun WeatherApp() {
    // Der Back Stack ist eine Liste: Navigieren = Element hinzufügen oder entfernen
    val backStack = rememberNavBackStack(CityList)

    // Ohne Decorator ist das ViewModel an die Activity gebunden
    val weatherViewModel: WeatherViewModel = viewModel()

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<CityList> {
                CityListScreen(
                    cities = fakeCities,
                    onCityClick = { city ->
                        weatherViewModel.loadWeather(city)
                        backStack.add(CityWeather(city))
                    },
                )
            }
            entry<CityWeather> { key ->
                WeatherScreen(
                    city = key.city,
                    viewModel = weatherViewModel,
                )
            }
        },
    )
}
