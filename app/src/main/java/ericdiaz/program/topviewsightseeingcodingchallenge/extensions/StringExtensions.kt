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

fun Double.getTempFormat(): String {
    return String.format("%.1f", this).let { "$it°" }
}

fun Double.getHighTempFormat(): String {
    return String.format("%.1f", this).let { "H $it°" }
}
fun Double.getLowTempFormat(): String {
    return String.format("%.1f", this).let { "L $it°" }
}