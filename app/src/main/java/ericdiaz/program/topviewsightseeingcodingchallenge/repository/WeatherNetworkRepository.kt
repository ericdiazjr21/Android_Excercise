package ericdiaz.program.topviewsightseeingcodingchallenge.repository

import ericdiaz.program.topviewsightseeingcodingchallenge.network.WeatherService
import javax.inject.Inject

class WeatherNetworkRepository(@Inject val weatherService: WeatherService) {

    companion object {
        private const val SECRET_KEY = "fe835d57e4500beca2f741375c7f1900"
        private const val UNITS = "auto"
        private const val EXCLUSIONS = "minutely,hourly,alerts,flags"
    }

    fun getWeatherResponse(
        latitude: Double,
        longitude: Double
    ) {
        weatherService.getWeatherResponse(SECRET_KEY, latitude, longitude, UNITS, EXCLUSIONS)
    }
}