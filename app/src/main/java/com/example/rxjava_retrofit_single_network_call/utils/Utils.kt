package com.example.rxjava_retrofit_single_network_call.utils

import android.content.Context
import android.net.ConnectivityManager

import java.util.regex.Pattern

class Utils {

    private val LATITUDE_PATTERN = Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)")

    private val LONGITUDE_PATTERN = Pattern.compile("\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$")

    fun validateCoordinates(latitude: Double, longitude: Double): Boolean {

        return LATITUDE_PATTERN.matcher(latitude.toString() + "").matches() &&
                LONGITUDE_PATTERN.matcher(longitude.toString() + "").matches()
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }
}
