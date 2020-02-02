package com.exuberant.weatherradar.ui.weather.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.exuberant.weatherradar.R
import com.exuberant.weatherradar.data.ApixuWeatherApiService
import com.exuberant.weatherradar.data.network.ConnectivityInterceptor
import com.exuberant.weatherradar.data.network.ConnectivityInterceptorImpl
import com.exuberant.weatherradar.data.network.response.CurrentWeatherResponse
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        val apiService =
            ApixuWeatherApiService(ConnectivityInterceptorImpl(context!!))
        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getCurrentWeather("Lucknow")
                if (currentWeatherResponse.isSuccessful){
                    textView.text = currentWeatherResponse.body().toString()
                } else {
                    Toast.makeText(context, currentWeatherResponse.errorBody().toString(), Toast.LENGTH_SHORT).show()
                }
        }
    }

}
