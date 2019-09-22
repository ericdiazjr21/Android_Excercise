package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ericdiaz.program.topviewsightseeingcodingchallenge.di.WeatherApplication
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherDatabaseRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory @Inject constructor(
    private val application: Application,
    private val weatherNetworkRepository: WeatherNetworkRepository,
    private val weatherDatabaseRepository: WeatherDatabaseRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            WeatherViewModel(application, weatherNetworkRepository,weatherDatabaseRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}