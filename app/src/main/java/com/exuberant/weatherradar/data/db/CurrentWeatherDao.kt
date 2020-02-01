package com.exuberant.weatherradar.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exuberant.weatherradar.data.db.entity.CURRENT_WEATHER_ID
import com.exuberant.weatherradar.data.db.entity.CurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getCurrentWeatherEntry(): LiveData<CurrentWeatherEntry>
}