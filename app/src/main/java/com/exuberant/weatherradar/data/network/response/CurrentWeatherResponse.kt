package com.exuberant.weatherradar.data.network.response

import com.exuberant.weatherradar.data.db.entity.CurrentWeatherEntry
import com.exuberant.weatherradar.data.db.entity.Location
import com.exuberant.weatherradar.data.db.entity.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)