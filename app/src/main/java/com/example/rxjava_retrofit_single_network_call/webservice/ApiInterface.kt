package com.example.rxjava_retrofit_single_network_call.webservice


import com.example.rxjava_retrofit_single_network_call.models.WeatherResponseDO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("forecast/{apikey}/{latlang}")
    fun getWeatherReport(
        @Path(value = "apikey", encoded = true) apiKey: String,
        @Path(value = "latlang", encoded = true) latLang: String
    ): Single<WeatherResponseDO>

}

