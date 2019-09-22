package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.di

import dagger.Module
import dagger.Provides
import ericdiaz.program.topviewsightseeingcodingchallenge.di.WeatherApplication
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModelFactory
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun providesWeatherViewModelFactory(application: WeatherApplication,weatherNetworkRepository: WeatherNetworkRepository): WeatherViewModelFactory {
        return WeatherViewModelFactory(application,weatherNetworkRepository)
    }
}