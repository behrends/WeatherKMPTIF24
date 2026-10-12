package com.example.weatherkmptif24.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.weatherkmptif24.data.fakeCities
import com.example.weatherkmptif24.model.City
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

// Routen: jeder Screen ist ein Typ, Argumente sind Properties
@Serializable
data object CityList : NavKey

@Serializable
data class CityWeather(val city: City) : NavKey

// iOS kennt keine Reflection: alle Routen müssen hier angemeldet werden,
// damit der Back Stack gespeichert und wiederhergestellt werden kann
private val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(CityList::class, CityList.serializer())
            subclass(CityWeather::class, CityWeather.serializer())
        }
    }
}

@Composable
fun WeatherApp() {
    // Der Back Stack ist eine Liste: Navigieren = Element hinzufügen oder entfernen
    val backStack = rememberNavBackStack(navConfig, CityList)

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
