package ericdiaz.program.topviewsightseeingcodingchallenge.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getDay
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getHighTempFormat
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getLowTempFormat
import ericdiaz.program.topviewsightseeingcodingchallenge.common.extensions.getMilliSeconds
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeekdayWeather
import ericdiaz.program.topviewsightseeingcodingchallenge.view.utils.WeatherIcons
import kotlinx.android.synthetic.main.weekday_weather_item_view.view.*
import java.util.*

class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(weekdayWeather: WeekdayWeather) {

        Picasso.get().load(WeatherIcons.weatherIconMap[weekdayWeather.iconId])
            .into(itemView.weather_icon_image_view)

        itemView.day_of_the_week_text_view.text =
            Date(weekdayWeather.unixTime.getMilliSeconds()).toString().getDay()

        itemView.weekday_temperature_low_text_view.text =
            weekdayWeather.lowTemperature.getLowTempFormat()

        itemView.weekday_temperature_high_text_view.text =
            weekdayWeather.highTemperature.getHighTempFormat()
    }
}