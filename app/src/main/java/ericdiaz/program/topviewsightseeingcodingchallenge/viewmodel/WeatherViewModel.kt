package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import androidx.lifecycle.ViewModel
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

private val disposables: CompositeDisposable = CompositeDisposable()

class WeatherViewModel(@Inject val weatherNetworkRepository: WeatherNetworkRepository) :
    ViewModel() {

    fun getWeatherResponse(latitude: Double, longitude: Double) {

        disposables.add(
            weatherNetworkRepository
                .getWeatherResponse(latitude, longitude)
                .subscribe()
        )
    }
}