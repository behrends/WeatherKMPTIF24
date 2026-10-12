package com.example.weatherkmptif24.data

import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.model.CurrentWeather
import kotlinx.coroutines.delay
import java.io.IOException

class FakeWeatherRepository(
    private val shouldFail: Boolean = false,
) : WeatherRepository {

    override suspend fun getCurrentWeather(city: City): CurrentWeather {
        delay(1500) // simuliert die Antwortzeit eines Servers
        if (shouldFail) throw IOException("Keine Verbindung zum Server (simuliert)")
        return fakeCurrentWeather[city.name]
            ?: throw IOException("Keine Wetterdaten für ${city.name}")
    }
}
