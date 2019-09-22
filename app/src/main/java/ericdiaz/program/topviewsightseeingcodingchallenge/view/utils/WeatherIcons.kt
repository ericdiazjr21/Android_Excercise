package ericdiaz.program.topviewsightseeingcodingchallenge.view.utils

object WeatherIcons {

    val weatherIconMap: MutableMap<String, String> = mutableMapOf()

    private const val ICON_URL = "http://openweathermap.org/img/wn/"

    private const val CLEAR_DAY = "01d@2x.png"
    private const val CLEAR_NIGHT = "01n@2x.png"
    private const val RAIN = "10d@2x.png"
    private const val SNOW = "13d@2x.png"
    private const val SLEET = "13d@2x.png"
    private const val WIND = "04d@2x.png"
    private const val FOG = "50d@2x.png"
    private const val CLOUDY = "03d@2x.png"
    private const val PARTLY_CLOUDY_DAY = "02d@2x.png"
    private const val PARTLY_CLOUDY_NIGHT = "02n@2x.png"


    init {
        weatherIconMap.apply {
            put("clear-day", ICON_URL + CLEAR_DAY)
            put("clear-night", ICON_URL + CLEAR_NIGHT)
            put("rain", ICON_URL + RAIN)
            put("snow", ICON_URL + SNOW)
            put("sleet", ICON_URL + SLEET)
            put("wind", ICON_URL + WIND)
            put("fog", ICON_URL + FOG)
            put("cloudy", ICON_URL + CLOUDY)
            put("partly-cloudy-day", ICON_URL + PARTLY_CLOUDY_DAY)
            put("partly-cloudy-night", ICON_URL + PARTLY_CLOUDY_NIGHT)
        }
    }
}