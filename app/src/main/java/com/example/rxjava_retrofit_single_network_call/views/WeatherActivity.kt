package com.example.rxjava_retrofit_single_network_call.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava_retrofit_single_network_call.R
import com.example.rxjava_retrofit_single_network_call.models.WeatherResponseDO
import com.example.rxjava_retrofit_single_network_call.presenters.WeatherPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class WeatherActivity : AppCompatActivity(), WeatherPresenter.WeatherPresenterInterface {

    private var weatherPresenter: WeatherPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        weatherPresenter = WeatherPresenter(this)

        // London 51.5074° N, 0.1278° W
        weatherPresenter!!.getWeatherInfo(
            "London",
            "166c199fe045e51a136adb2262e1fd86",
            51.5074,
            0.1278
        )

        // Paris 48.8566° N, 2.3522° E
        weatherPresenter!!.getWeatherInfo(
            "Paris",
            "166c199fe045e51a136adb2262e1fd86",
            48.8566,
            2.3522
        )

        // NewYork 40.7128° N, 74.0060° W
        weatherPresenter!!.getWeatherInfo(
            "NewYork",
            "166c199fe045e51a136adb2262e1fd86",
            40.7128,
            74.0060
        )

        //Los Angeles, 34.0522° N, 118.2437° W
        weatherPresenter!!.getWeatherInfo(
            "Los Angeles",
            "166c199fe045e51a136adb2262e1fd86",
            34.0522,
            118.2437
        )

        // Tokyo 35.6804° N, 139.7690° E
        weatherPresenter!!.getWeatherInfo(
            "Tokyo",
            "166c199fe045e51a136adb2262e1fd86",
            35.6804,
            139.7690
        )

    }

    override fun onSuccess(countryName: String, nearbyResponseDO: WeatherResponseDO) {

        tvWeatherReport!!.append("$countryName\n \n\t \t \t${nearbyResponseDO.currentWeatherDO!!.getTemperature()}°C, ${(nearbyResponseDO.currentWeatherDO!!.getHumidity()!! * 100).roundToInt()}% Humidity, ${(nearbyResponseDO.currentWeatherDO!!.getPrecipProbability()!! * 100).roundToInt()}% Chance of rain.\n \n \n")
    }

    override fun onFailure(message: String?) {
        tvWeatherReport!!.append("$message\n \n")
    }
}
