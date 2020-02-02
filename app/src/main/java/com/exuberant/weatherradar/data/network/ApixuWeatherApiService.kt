package com.exuberant.weatherradar.data.network

import com.exuberant.weatherradar.data.network.response.CurrentWeatherResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "5f7e5aa5ee3f2eaa8f41a2c6c95b199b"

//http://api.weatherstack.com/current?access_key=5f7e5aa5ee3f2eaa8f41a2c6c95b199b&query=Vellore

interface ApixuWeatherApiService {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("query") location: String,
        @Query("unit") units: String = "m"
    ): Response<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ApixuWeatherApiService {

            val requestInterceptor =  Interceptor {chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("access_key",
                        API_KEY
                    )
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }

}