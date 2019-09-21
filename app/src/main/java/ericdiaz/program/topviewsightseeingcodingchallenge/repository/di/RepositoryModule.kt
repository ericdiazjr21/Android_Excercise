package ericdiaz.program.topviewsightseeingcodingchallenge.repository.di

import dagger.Module
import dagger.Provides
import ericdiaz.program.topviewsightseeingcodingchallenge.network.WeatherService
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesWeatherNetworkRepository(weatherService: WeatherService): WeatherNetworkRepository {
        return WeatherNetworkRepository(weatherService)
    }
}