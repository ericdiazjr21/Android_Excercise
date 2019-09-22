package ericdiaz.program.topviewsightseeingcodingchallenge.data.repository

import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.WeatherResponseDAO
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Database Repository for conducting database operations
 *
 * Created : 9/22/19
 *
 * @author Eric Diaz
 */
class WeatherDatabaseRepository @Inject constructor(private val weatherResponseDAO: WeatherResponseDAO) {

    fun getCachedWeatherResponse(): Single<WeatherResponse> {
        return weatherResponseDAO.getCachedWeatherResponse()
    }

    fun insertWeatherResponse(weatherResponse: WeatherResponse): Completable {
        return weatherResponseDAO.insertWeatherResponse(weatherResponse)
    }
}