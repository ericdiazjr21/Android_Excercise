package ericdiaz.program.topviewsightseeingcodingchallenge.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    var date: String,

    @SerializedName("time")
    val unixTime: Long,

    @SerializedName("icon")
    val iconId: String,

    @SerializedName("temperature")
    val temperature: Double
)
