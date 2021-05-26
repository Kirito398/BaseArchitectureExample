package ru.sir.data.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

class NetworkHandler(context: Context) {
    private val connectivityManager: ConnectivityManager? = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

    fun isNetworkConnected(): Boolean {
        connectivityManager?.let {
            return if (Build.VERSION.SDK_INT < 23) {
                connectivityManager.activeNetworkInfo?.isConnected ?: false
            } else {
                val network: Network? = connectivityManager.activeNetwork
                val networkCapabilities: NetworkCapabilities? = connectivityManager.getNetworkCapabilities(network)

                (networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false
                        || networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false)
            }
        }
        return false
    }
}