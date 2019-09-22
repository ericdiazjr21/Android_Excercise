package ericdiaz.program.topviewsightseeingcodingchallenge.data.db.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.WeatherDatabase
import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.WeatherResponseDAO
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesWeatherDatabase(context: Context): WeatherDatabase {
        synchronized(WeatherDatabase::class) {
            return Room
                .databaseBuilder(context, WeatherDatabase::class.java, "WeatherForecast.db")
                .build()
        }
    }

    @Singleton
    @Provides
    fun providesWeatherResponseDAO(weatherDatabase: WeatherDatabase): WeatherResponseDAO {
        return weatherDatabase.getWeatherResponseDao()
    }
}