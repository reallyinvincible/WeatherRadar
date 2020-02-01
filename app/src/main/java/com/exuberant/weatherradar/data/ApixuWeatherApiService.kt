package com.exuberant.weatherradar.data

import com.exuberant.weatherradar.data.network.response.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "5f7e5aa5ee3f2eaa8f41a2c6c95b199b"

//http://api.weatherstack.com/current?access_key=5f7e5aa5ee3f2eaa8f41a2c6c95b199b&query=Vellore

interface ApixuWeatherApiService {

    @GET("current?access_key=$API_KEY")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("unit") units: String = "m"
        //@Query("language") languageCode: String = "en"
    ): Call<CurrentWeatherResponse>

    companion object {
        operator fun invoke():  ApixuWeatherApiService {
            return Retrofit.Builder()
                .baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }

}