package ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.di

import dagger.Module
import dagger.Provides
import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.WeatherResponseDAO
import ericdiaz.program.topviewsightseeingcodingchallenge.data.network.WeatherService
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherDatabaseRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherNetworkRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesWeatherNetworkRepository(weatherService: WeatherService): WeatherNetworkRepository {
        return WeatherNetworkRepository(weatherService)
    }

    @Singleton
    @Provides
    fun providesWeatherDatabaseRepository(weatherResponseDAO: WeatherResponseDAO): WeatherDatabaseRepository {
        return WeatherDatabaseRepository(weatherResponseDAO)
    }
}