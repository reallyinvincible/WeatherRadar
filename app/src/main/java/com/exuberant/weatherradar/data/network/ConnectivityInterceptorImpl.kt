package com.exuberant.weatherradar.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import com.exuberant.weatherradar.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.wait
import java.io.IOException

class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()){
            throw NoConnectivityException()
        }
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean{
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting()
    }
}