package com.exuberant.weatherradar.data.network

import androidx.lifecycle.LiveData
import com.exuberant.weatherradar.data.ApixuWeatherApiService
import com.exuberant.weatherradar.data.network.response.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {



    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override suspend fun fetchCurrentWeather(location: String) {
        val fetchedCurrentWeather = apixuWeatherApiService
            .getCurrentWeather(location)
    }
}