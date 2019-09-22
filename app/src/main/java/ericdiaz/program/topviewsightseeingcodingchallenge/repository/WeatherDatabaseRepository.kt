package ericdiaz.program.topviewsightseeingcodingchallenge.repository

import ericdiaz.program.topviewsightseeingcodingchallenge.db.WeatherResponseDAO
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class WeatherDatabaseRepository @Inject constructor(private val weatherResponseDAO: WeatherResponseDAO) {

    fun getCachedWeatherResponse(): Single<WeatherResponse> {
        return weatherResponseDAO.getCachedWeatherResponse()
    }

    fun insertWeatherResponse(weatherResponse: WeatherResponse): Completable {
        return weatherResponseDAO.insertWeatherResponse(weatherResponse)
    }
}