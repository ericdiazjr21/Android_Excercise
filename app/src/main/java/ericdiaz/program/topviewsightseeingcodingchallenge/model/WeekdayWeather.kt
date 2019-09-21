package ericdiaz.program.topviewsightseeingcodingchallenge.model

import com.google.gson.annotations.SerializedName

data class WeekdayWeather(
    @SerializedName("time")
    val unixTime: Long,
    @SerializedName("icon")
    val iconId: String,
    @SerializedName("temperatureHigh")
    val highTemperature: Double,
    @SerializedName("temperatureLow")
    val lowTemperature: Double
)