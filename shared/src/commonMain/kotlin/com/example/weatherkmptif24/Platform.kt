package com.example.weatherkmptif24

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform