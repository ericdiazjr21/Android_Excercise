package ericdiaz.program.topviewsightseeingcodingchallenge.repository.di

import dagger.Module
import ericdiaz.program.topviewsightseeingcodingchallenge.network.WeatherService
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository

@Module
class RepositoryModule {

    fun providesWeatherNetworkRepository(weatherService: WeatherService): WeatherNetworkRepository {
        return WeatherNetworkRepository(weatherService)
    }
}