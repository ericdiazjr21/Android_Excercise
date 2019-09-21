package ericdiaz.program.topviewsightseeingcodingchallenge.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    var responseId: String,
    @SerializedName("timezone")
    val location: String,
    @SerializedName("currently")
    val currentWeather: CurrentWeather,
    @SerializedName("dailyForecast")
    val dailyForecast: DailyForecast
)