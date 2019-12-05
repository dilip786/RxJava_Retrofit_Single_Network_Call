package com.example.rxjava_retrofit_single_network_call.models

import com.google.gson.annotations.SerializedName

import java.text.DecimalFormat

class CurrentWeatherDO {

    @SerializedName("precipProbability")
    private val precipProbability: Double = 0.toDouble()

    @SerializedName("temperature")
    private var temperature: Double = 0.toDouble()

    @SerializedName("humidity")
    private val humidity: Double = 0.toDouble()

    fun getPrecipProbability(): Double? {
        return precipProbability
    }

    fun getTemperature(): Double? {

        val df = DecimalFormat("#.##")
        temperature = java.lang.Double.valueOf(df.format(temperature))
        return temperature
    }

    fun getHumidity(): Double? {
        return humidity
    }

}
