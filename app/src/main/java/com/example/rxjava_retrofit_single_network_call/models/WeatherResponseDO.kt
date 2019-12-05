package com.example.rxjava_retrofit_single_network_call.models

import com.google.gson.annotations.SerializedName

class WeatherResponseDO {

    @SerializedName("latitude")
    private val latitude: Double = 0.toDouble()

    @SerializedName("longitude")
    private val longitude: Double = 0.toDouble()

    @SerializedName("timezone")
    private val timezone: String? = null

    @SerializedName("currently")
    val currentWeatherDO: CurrentWeatherDO? = null

}
