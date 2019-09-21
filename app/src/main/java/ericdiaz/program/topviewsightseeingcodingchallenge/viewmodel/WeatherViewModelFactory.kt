package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory @Inject constructor(private val weatherNetworkRepository: WeatherNetworkRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            WeatherViewModel(weatherNetworkRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}