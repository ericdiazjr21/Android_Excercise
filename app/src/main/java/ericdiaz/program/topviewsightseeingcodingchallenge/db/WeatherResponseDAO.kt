package ericdiaz.program.topviewsightseeingcodingchallenge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface WeatherResponseDAO {

    @Query("SELECT * FROM weatherForecastTable")
    fun getCachedWeatherResponse(): Single<WeatherResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherResponse(weatherResponse: WeatherResponse): Completable

}