package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.di

import dagger.Module
import dagger.Provides
import ericdiaz.program.topviewsightseeingcodingchallenge.common.di.WeatherApplication
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherDatabaseRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherNetworkRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModelFactory
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun providesWeatherViewModelFactory(
        application: WeatherApplication,
        weatherNetworkRepository: WeatherNetworkRepository,
        weatherDatabaseRepository: WeatherDatabaseRepository
    )
            : WeatherViewModelFactory {

        return WeatherViewModelFactory(
            application,
            weatherNetworkRepository,
            weatherDatabaseRepository
        )
    }
}