package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getLocation
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getMilliSeconds
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.isNetworkConnected
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherDatabaseRepository
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.WeatherNetworkRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.text.DateFormat
import java.util.*
import javax.inject.Inject


class WeatherViewModel @Inject constructor(
    application: Application,
    private val weatherNetworkRepository: WeatherNetworkRepository,
    private val weatherDatabaseRepository: WeatherDatabaseRepository
) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val weatherData: MutableLiveData<State> = MutableLiveData()

    init {
        getWeather()
    }

    fun getWeatherData(): LiveData<State> {
        return weatherData
    }

    fun refreshWeatherData() {
        getWeather()
    }

    private fun getWeather() {
        val applicationContext = getApplication<Application>().applicationContext

        applicationContext.getLocation(
            OnSuccessListener { location ->
                if (location != null && applicationContext.isNetworkConnected()) {
                    getWeatherResponse(location.latitude, location.longitude)
                } else {
                    getCachedWeatherResponse()
                }
            },
            OnFailureListener {
                weatherData.value = State.Failure(it, StateDescriptor.LOCATION_ERROR)
            }
        )
    }

    private fun getWeatherResponse(latitude: Double, longitude: Double) {
        weatherData.value = State.Loading

        disposables.add(weatherNetworkRepository
            .getWeatherResponse(latitude, longitude)
            .map { response ->
                run {
                    response.currentWeather.date = DateFormat
                        .getDateTimeInstance()
                        .format(Date(response.currentWeather.unixTime.getMilliSeconds()))

                    response.responseId = "Single_Entry_Response"
                }
                return@map response
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { response ->
                run { cacheWeatherResponse(response) }
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

    private fun cacheWeatherResponse(weatherResponse: WeatherResponse) {
        disposables.add(
            weatherDatabaseRepository
                .insertWeatherResponse(weatherResponse)
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }

    private fun getCachedWeatherResponse() {
        disposables.add(weatherDatabaseRepository
            .getCachedWeatherResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    weatherData.value = State.Success(it, StateDescriptor.FROM_DATABASE)
                },
                onError = {
                    weatherData.value = State.Failure(it, StateDescriptor.NO_DATA_SOURCE_AVAILABLE)
                }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}