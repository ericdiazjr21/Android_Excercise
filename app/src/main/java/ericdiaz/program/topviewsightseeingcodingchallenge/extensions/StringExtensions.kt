package ericdiaz.program.topviewsightseeingcodingchallenge.extensions

fun String.getDay(): String {

    return when (substring(0, 3)) {
        "Mon" -> "Monday"
        "Tue" -> "Tuesday"
        "Wed" -> "Wednesday"
        "Thu" -> "Thursday"
        "Fri" -> "Friday"
        "Sat" -> "Saturday"
        "Sun" -> "Sunday"
        else -> "Error"
    }
}