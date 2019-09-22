package ericdiaz.program.topviewsightseeingcodingchallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.util.WeatherDatabaseTypeConverters
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse

@Database(entities = [WeatherResponse::class], version = 1, exportSchema = false)
@TypeConverters(WeatherDatabaseTypeConverters::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherResponseDao(): WeatherResponseDAO
}