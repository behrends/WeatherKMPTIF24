package com.example.weatherkmptif24.data.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// Ein HttpClient für die ganze App.
// Ohne Angabe der Engine nimmt Ktor die der Plattform: OkHttp (Android), Darwin (iOS)
val httpClient = HttpClient {
    expectSuccess = true // HTTP-Fehler (4xx, 5xx) als Exception werfen
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}
