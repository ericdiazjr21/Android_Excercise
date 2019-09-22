package ericdiaz.program.topviewsightseeingcodingchallenge.data.network

import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast/{secret_key}/{latitude},{longitude}")
    fun getWeatherResponse(
        @Path("secret_key") secretKey: String,
        @Path("latitude") latitude: Double,
        @Path("longitude") longitude: Double,
        @Query("units") units: String,
        @Query("excludes") excludes: String
    ): Single<WeatherResponse>
}