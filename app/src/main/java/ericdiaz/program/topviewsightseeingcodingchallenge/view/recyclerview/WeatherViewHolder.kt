package ericdiaz.program.topviewsightseeingcodingchallenge.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.topviewsightseeingcodingchallenge.extensions.getDay
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeekdayWeather
import kotlinx.android.synthetic.main.weekday_weather_item_view.view.*
import java.util.*

class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(weekdayWeather: WeekdayWeather) {
        itemView.day_of_the_week_text_view.text =
            Date(weekdayWeather.unixTime.times(1000)).toString().getDay()

        itemView.weekday_temperature_low_text_view.text = weekdayWeather.lowTemperature.toString()

        itemView.weekday_temperature_high_text_view.text = weekdayWeather.highTemperature.toString()
    }
}