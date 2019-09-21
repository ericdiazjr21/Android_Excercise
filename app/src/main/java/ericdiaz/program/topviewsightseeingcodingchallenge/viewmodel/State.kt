package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse

sealed class State {
    data class Success(
        val weatherResponse: WeatherResponse,
        val stateDescriptor: String
    ) : State()

    data class Failure(
        val throwable: Throwable,
        val stateDescriptor: String
    ) : State()

    object Loading : State()
}

object StateDescriptor {

    const val NO_DATA_SOURCE_AVAILABLE = "no network or database data"
    const val LOCATION_ERROR = "no location provided"
    const val NETWORK_ERROR = "no network available"
    const val UNKNOWN_ERROR = "no idea man"
    const val FROM_DATABASE = "data came from database"
    const val FROM_NETWORK = "data came from network"
}