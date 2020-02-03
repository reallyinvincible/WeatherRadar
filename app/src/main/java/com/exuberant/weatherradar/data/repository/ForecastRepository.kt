package com.exuberant.weatherradar.data.repository

import androidx.lifecycle.LiveData
import com.exuberant.weatherradar.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry>

}