package com.exuberant.weatherradar.data.network

import androidx.lifecycle.LiveData
import com.exuberant.weatherradar.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )

}