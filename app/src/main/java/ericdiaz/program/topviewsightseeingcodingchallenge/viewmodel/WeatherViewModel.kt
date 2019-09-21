package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import ericdiaz.program.topviewsightseeingcodingchallenge.di.WeatherApplication
import ericdiaz.program.topviewsightseeingcodingchallenge.extensions.getLocation
import ericdiaz.program.topviewsightseeingcodingchallenge.extensions.isNetworkConnected
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import java.text.DateFormat
import java.util.*
import javax.inject.Inject


class WeatherViewModel @Inject constructor(
    private val weatherNetworkRepository: WeatherNetworkRepository,
    application: Application
) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val weatherData: MutableLiveData<State> = MutableLiveData()

    fun getWeather() {
        val applicationContext = getApplication<WeatherApplication>().applicationContext

        applicationContext.getLocation(
            OnSuccessListener { location ->
                if (location != null && applicationContext.isNetworkConnected()) {
                    getWeatherResponse(location.latitude, location.longitude)
                }
            },
            OnFailureListener {
                weatherData.value = State.Failure(it, StateDescriptor.LOCATION_ERROR)
            }
        )
    }

    private fun getWeatherResponse(latitude: Double, longitude: Double) {
        disposables.add(weatherNetworkRepository
            .getWeatherResponse(latitude, longitude)
            .map { response ->
                run {
                    response.currentWeather.date = DateFormat
                        .getDateTimeInstance()
                        .format(Date(response.currentWeather.unixTime.times(1000)))
                }
                return@map response
            }
            .subscribeBy(
                onSuccess = {
                    weatherData.value = State.Success(it, StateDescriptor.FROM_NETWORK)
                },

                onError = {
                    weatherData.value = State.Failure(it, StateDescriptor.NETWORK_ERROR)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}