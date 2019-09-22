package ericdiaz.program.topviewsightseeingcodingchallenge.db.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ericdiaz.program.topviewsightseeingcodingchallenge.model.CurrentWeather
import ericdiaz.program.topviewsightseeingcodingchallenge.model.DailyForecast

class WeatherDatabaseTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun dailyForecastSerializer(dailyForecast: DailyForecast): String {
        return gson.toJson(dailyForecast)
    }

    @TypeConverter
    fun dailyForecastDeserializer(cachedDailyForecast: String): DailyForecast {
        return gson.fromJson(cachedDailyForecast, object : TypeToken<DailyForecast>() {}.type)
    }

    @TypeConverter
    fun currentWeatherSerializer(currentWeather: CurrentWeather): String {
        return gson.toJson(currentWeather)
    }

    @TypeConverter
    fun currentWeatherDeserializer(cachedCurrentWeather: String): CurrentWeather {
        return gson.fromJson(cachedCurrentWeather, object : TypeToken<CurrentWeather>() {}.type)
    }
}