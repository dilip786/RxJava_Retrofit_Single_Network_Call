package com.example.rxjava_retrofit_single_network_call.models

import com.google.gson.annotations.SerializedName

class WeatherErrorResponseDO {

    @SerializedName("code")
    val code: Int? = null

    @SerializedName("error")
    val error: String? = null

    fun getCode(): Int {
        return code!!
    }

}
