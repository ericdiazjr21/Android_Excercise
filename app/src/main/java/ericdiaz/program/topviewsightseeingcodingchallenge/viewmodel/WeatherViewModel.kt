package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import ericdiaz.program.topviewsightseeingcodingchallenge.di.WeatherApplication
import ericdiaz.program.topviewsightseeingcodingchallenge.extensions.getLocation
import ericdiaz.program.topviewsightseeingcodingchallenge.extensions.isNetworkConnected
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.WeatherNetworkRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.text.DateFormat
import java.util.*
import javax.inject.Inject


class WeatherViewModel @Inject constructor(application: Application,
    private val weatherNetworkRepository: WeatherNetworkRepository
) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val weatherData: MutableLiveData<State> = MutableLiveData()

    init {
        getWeather()
    }

    fun getWeatherData():LiveData<State>{
        return weatherData
    }

    private fun getWeather() {
        val applicationContext = getApplication<Application>().applicationContext

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
            .observeOn(AndroidSchedulers.mainThread())
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