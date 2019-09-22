package ericdiaz.program.topviewsightseeingcodingchallenge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse

@Database(entities = [WeatherResponse::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherResponseDao(): WeatherResponseDAO
}