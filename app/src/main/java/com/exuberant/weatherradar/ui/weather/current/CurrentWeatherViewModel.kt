package com.exuberant.weatherradar.ui.weather.current

import androidx.lifecycle.ViewModel
import com.exuberant.weatherradar.data.repository.ForecastRepository
import com.exuberant.weatherradar.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather()
    }
}
