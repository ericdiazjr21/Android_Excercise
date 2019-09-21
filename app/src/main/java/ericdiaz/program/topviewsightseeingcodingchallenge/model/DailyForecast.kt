package ericdiaz.program.topviewsightseeingcodingchallenge.model

import com.google.gson.annotations.SerializedName

data class DailyForecast(@SerializedName("data") val eightDayForecast: List<WeekdayWeather>)
