package ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel

import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeatherResponse

sealed class State {
    data class Success(
        val weatherResponse: WeatherResponse,
        val stateDescriptor: String
    ) : State()

    data class Failure(
        val throwable: Throwable,
        val stateDescriptor: String = StateDescriptor.UNKNOWN_ERROR
    ) : State()

    object Loading : State()
}

object StateDescriptor {

    const val NO_DATA_SOURCE_AVAILABLE = "No network or database data"
    const val LOCATION_ERROR = "No location provided"
    const val NETWORK_ERROR = "No network available"
    const val UNKNOWN_ERROR = "No idea man"
    const val FROM_DATABASE = "Data came from database"
    const val FROM_NETWORK = "Data came from network"
}