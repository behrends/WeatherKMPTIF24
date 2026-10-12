package com.example.weatherkmptif24.data

import com.example.weatherkmptif24.data.api.CurrentDto
import com.example.weatherkmptif24.data.api.ForecastResponse
import com.example.weatherkmptif24.data.api.httpClient
import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.model.CurrentWeather
import com.example.weatherkmptif24.model.WeatherCondition
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiWeatherRepository(
    private val client: HttpClient = httpClient,
) : WeatherRepository {

    override suspend fun getCurrentWeather(city: City): CurrentWeather {
        val response: ForecastResponse = client.get("https://api.open-meteo.com/v1/forecast") {
            parameter("latitude", city.latitude)
            parameter("longitude", city.longitude)
            parameter("current", "temperature_2m,weather_code,wind_speed_10m")
            parameter("timezone", "auto")
        }.body()
        return response.current.toCurrentWeather()
    }
}

private fun CurrentDto.toCurrentWeather() = CurrentWeather(
    temperature = temperature,
    windSpeed = windSpeed,
    condition = weatherConditionFromWmoCode(weatherCode),
)

// WMO-Wettercodes, siehe https://open-meteo.com/en/docs (Abschnitt "WMO Weather interpretation codes")
private fun weatherConditionFromWmoCode(code: Int): WeatherCondition = when (code) {
    0 -> WeatherCondition.CLEAR
    1, 2 -> WeatherCondition.PARTLY_CLOUDY
    3 -> WeatherCondition.CLOUDY
    45, 48 -> WeatherCondition.FOG
    in 51..67, in 80..82 -> WeatherCondition.RAIN
    in 71..77, 85, 86 -> WeatherCondition.SNOW
    in 95..99 -> WeatherCondition.THUNDERSTORM
    else -> WeatherCondition.CLOUDY
}
