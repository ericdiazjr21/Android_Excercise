package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.di

import dagger.Module
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModelFactory

@Module
class ViewModelModule {

    fun providesWeatherViewModelFactory(weatherNetworkRepository: WeatherNetworkRepository): WeatherViewModelFactory {
        return WeatherViewModelFactory(weatherNetworkRepository)
    }
}