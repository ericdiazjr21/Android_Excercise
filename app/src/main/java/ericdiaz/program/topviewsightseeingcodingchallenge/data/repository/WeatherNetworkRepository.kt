package ericdiaz.program.topviewsightseeingcodingchallenge.data.repository

import ericdiaz.program.topviewsightseeingcodingchallenge.data.network.WeatherService
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * A Repository for conducting network operations to API
 *
 * Created 9/21/19
 *
 * @author Eric Diaz
 */

class WeatherNetworkRepository @Inject constructor(private val weatherService: WeatherService) {

    companion object {
        private const val SECRET_KEY = "fe835d57e4500beca2f741375c7f1900"
        private const val UNITS = "auto"
        private const val EXCLUSIONS = "minutely,hourly,alerts,flags"
    }

    fun getWeatherResponse(
        latitude: Double,
        longitude: Double
    ): Single<WeatherResponse> {
        return weatherService.getWeatherResponse(SECRET_KEY, latitude, longitude, UNITS, EXCLUSIONS)
    }
}